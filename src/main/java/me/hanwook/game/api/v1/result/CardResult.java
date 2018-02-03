package me.hanwook.game.api.v1.result;

import lombok.Data;
import me.hanwook.game.api.v1.domain.Card;
import me.hanwook.game.api.v1.domain.CardAct;
import me.hanwook.game.api.v1.domain.CardEffect;
import me.hanwook.game.common.result.Result;

@Data
public class CardResult extends Result {

    // 일련번호
    private Long id;

    // 카드 이름
    private String cardName;

    // 기본 공격력
    private Integer defaultOp;

    // 기본 방어력
    private Integer defaultDp;

    // 코스트
    private Integer cost;

    // 카드 발동 조건
    private CardAct cardAct;

    // 카드 효과
    private CardEffect cardEffect;

    public CardResult() { }

    public CardResult(Card card) {
        this.id = card.getId();
        this.cardName = card.getCardName();
        this.defaultOp = card.getDefaultOp();
        this.defaultDp = card.getDefaultDp();
        this.cost = card.getCost();
        this.cardAct = card.getCardAct();
        this.cardEffect = card.getCardEffect();
    }

}
