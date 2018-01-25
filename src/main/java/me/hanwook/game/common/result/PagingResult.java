package me.hanwook.game.common.result;

import lombok.Data;

@Data
public class PagingResult extends Result {

    protected Long totalCount;

    protected Integer offset;

    protected Integer size;
}
