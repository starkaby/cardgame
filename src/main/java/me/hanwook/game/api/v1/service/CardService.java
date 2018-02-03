package me.hanwook.game.api.v1.service;

import com.querydsl.jpa.impl.JPAQuery;
import me.hanwook.game.api.v1.domain.Card;
import me.hanwook.game.api.v1.domain.QCard;
import me.hanwook.game.api.v1.param.CardsParam;
import me.hanwook.game.api.v1.repository.CardRepository;
import me.hanwook.game.api.v1.result.CardResult;
import me.hanwook.game.api.v1.result.CardsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 목록 조회
     * @param param
     * @return
     */
    public CardsResult findCards(CardsParam param) {

        // jpaQuery
        QCard card = QCard.card;
        JPAQuery<Card> jpaQuery = new JPAQuery(entityManager);

        JPAQuery<Card> jpaQueryWhere = jpaQuery.from(card);

        // 총 갯수
        Long totalCount = jpaQueryWhere.fetchCount();

        List<Card> list = jpaQueryWhere.offset(param.getOffset()).limit(param.getSize()).fetch();

        List<CardResult> cardResults = list.stream().map(CardResult::new).collect(Collectors.toList());

        return new CardsResult(param, cardResults, totalCount);
    }
}
