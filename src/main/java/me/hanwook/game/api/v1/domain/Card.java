package me.hanwook.game.api.v1.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="t_cards")
@Data
public class Card {

    // 일련번호
    @Id
    @GeneratedValue
    private Long id;

    // 카드 이름
    @Column(length=255, nullable=false, unique=true)
    private String cardName;

    // 기본 공격력
    @Column(nullable=false)
    private Integer defaultOp;

    // 기본 방어력
    @Column(nullable=false)
    private Integer defaultDp;

    // 코스트
    @Column(nullable=false)
    private Integer cost;

    // 카드 발동 조건
    @Column(length=8)
    @Enumerated(EnumType.STRING)
    private CardAct cardAct;

    // 카드 효과
    @Column(length=13)
    @Enumerated(EnumType.STRING)
    private CardEffect cardEffect;

}
