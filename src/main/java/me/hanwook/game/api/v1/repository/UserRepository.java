package me.hanwook.game.api.v1.repository;

import me.hanwook.game.api.v1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * 사용자
 */
public interface UserRepository extends JpaRepository<User, Long>, QueryDslPredicateExecutor<User> {

}
