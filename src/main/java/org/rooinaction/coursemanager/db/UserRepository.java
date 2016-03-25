package org.rooinaction.coursemanager.db;

import java.util.List;

import org.rooinaction.coursemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, QueryDslPredicateExecutor<User>, UserRepositoryCustom {

	List<User> findByLastnameLike(String lastname);
	List<User> findByLastnameNotLike(String lastname);

	@Query("select u from User u where u.lastname = :lastname")
	List<User> findByLastname(@Param("lastname") String lastname);
	
//	@Modifying(clearAutomatically=true)
	@Modifying
	@Query("update User u set u.firstname = ?1 where u.lastname = ?2")
	int setFixedFirstnameFor(String firstname, String lastname);
}
