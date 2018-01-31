package me.hanwook.game.api.v1.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCard is a Querydsl query type for Card
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCard extends EntityPathBase<Card> {

    private static final long serialVersionUID = -429927300L;

    public static final QCard card = new QCard("card");

    public final EnumPath<CardAct> cardAct = createEnum("cardAct", CardAct.class);

    public final EnumPath<CardEffect> cardEffect = createEnum("cardEffect", CardEffect.class);

    public final StringPath cardName = createString("cardName");

    public final NumberPath<Integer> cost = createNumber("cost", Integer.class);

    public final NumberPath<Integer> defaultDp = createNumber("defaultDp", Integer.class);

    public final NumberPath<Integer> defaultOp = createNumber("defaultOp", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QCard(String variable) {
        super(Card.class, forVariable(variable));
    }

    public QCard(Path<? extends Card> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCard(PathMetadata metadata) {
        super(Card.class, metadata);
    }

}

