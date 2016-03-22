package org.rooinaction.coursemanager.db;
import java.util.List;

import org.rooinaction.coursemanager.model.Offering;
import org.springframework.data.jpa.repository.Query;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

@RooJpaRepository(domainType = Offering.class)
public interface OfferingRepository {
//	List<Offering> findByUser_Role(String role);

//	@Query(value="select * from offering o left outer join user u on o.user=u.id where u.role=?1", nativeQuery=true)
	@Query(value="select o from Offering o where o.user.role=?1", nativeQuery=false)
	List<Offering> fetchByUser_Role(String role);

/*	
 * spring security 4.0以上才支持org.springframework.security.data.repository.query.SecurityEvaluationContextExtension
	@Query(value="select o from Offering o where o.user.role=?1 or 1=?#{hasRole('ROLE_ADMIN') ? 1 : 0}", nativeQuery=false)
	List<Offering> fetchByUser_Role_Security(String role);
*/	
}
