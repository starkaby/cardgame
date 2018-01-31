package me.hanwook.game.api.v1.repository;

import me.hanwook.game.api.v1.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * 카드
 */
public interface CardRepository extends JpaRepository<Card, Long>, QueryDslPredicateExecutor<Card> {
}
