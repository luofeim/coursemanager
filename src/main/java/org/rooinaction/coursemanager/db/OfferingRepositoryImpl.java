package org.rooinaction.coursemanager.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.rooinaction.coursemanager.model.Offering;
import org.rooinaction.coursemanager.model.QOffering;
import org.rooinaction.coursemanager.model.QUser;
import org.rooinaction.coursemanager.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.query.SimpleSubQuery;

public class OfferingRepositoryImpl implements OfferingRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	public List<Offering> customFetchByJoin(String role) {
		QOffering qOffering = QOffering.offering;
		QUser quser = QUser.user;
		JPAQuery query = new JPAQuery(em);	
		List<Offering>  offerings = query.from(qOffering).leftJoin(qOffering.user, quser)
				.where(quser.role.eq(role)).list(qOffering);
		return(offerings);
	}

	public List<Offering> customFetchBySubQuery(String role) {
		QOffering qOffering = QOffering.offering;
		QUser quser = QUser.user;
		JPAQuery query = new JPAQuery(em);	
		SimpleSubQuery<User> subquery = new JPASubQuery().from(quser).where(quser.role.eq(role)).unique(quser);
		List<Offering>  offerings = query.from(qOffering).where(qOffering.user.eq(subquery)).list(qOffering);
		return(offerings);
	}
	
	static public String securitySqlFilter() {
		return securitySqlFilter(null, null);
	}
	
	static public String securitySqlFilter(String user) {
		return securitySqlFilter(null, user);
	}
	/*
	 * 自动根据权限增加sql语句的示例程序：
	 * 1) 未登录：and 1 = 0，不取任何数据 （未登录）
	 * 2) ROLE_USER: and user = #登录的user.id# （普通用户）
	 * 3）ROLE_ADMIN: and 1 = 1，取所有 （系统管理员）
	 * 4）ROLE_SHOPER: and producer = #登录的user.producer# （厂家商品管理员）
	 */
	static public String securitySqlFilter(String entityName, String userFieldName) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) //尚未登录
			return(" 1 = 0");
		String role = auth.getAuthorities().contains(new SimpleGrantedAuthority("admin")) ? "ROLE_ADMIN" : "ROLE_USER";
		String securitySql;
		if (role == "ROLE_ADMIN") //系统管理员
			securitySql = " 1 = 1";
		else { //普通用户或未登录
			StringBuilder sb = new StringBuilder(" ");
			User user = (User) auth.getPrincipal();
			if (user != null) {
				if (entityName != null)
					sb.append(entityName).append('.');
				sb.append(userFieldName == null? "user" : userFieldName).append(" = ").append(user.getId());
			}
			else //未知用户???
				securitySql = " 1 = 0";
			securitySql = sb.toString();
		}
		return securitySql;
	}
	
	@SuppressWarnings("unchecked")
	public List<Offering> findOfferingBySecurityRole(String locationName) {
		StringBuilder sql = new StringBuilder("select * from offering where location_name like :locationName");
		sql.append(" and ").append(securitySqlFilter());
		Query query = em.createNativeQuery(sql.toString(), Offering.class);
		query.setParameter("locationName", locationName + '%');
		List<Offering> results = query.getResultList();
		return (results);
	}

	public List<Offering> findOfferingBySecurityRole2(String locationName) {
		StringBuilder sql = new StringBuilder("select o from Offering o where o.locationName like :locationName");
		sql.append(" and ").append(securitySqlFilter());
		TypedQuery<Offering> query = em.createQuery(sql.toString(), Offering.class);
		query.setParameter("locationName", locationName + '%');
		List<Offering> results = query.getResultList();
		return (results);
	}
}
