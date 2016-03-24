package org.rooinaction.coursemanager.db;

import org.rooinaction.coursemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, QueryDslPredicateExecutor<User>, UserRepositoryCustom {

}
