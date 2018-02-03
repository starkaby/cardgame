package me.hanwook.game.api.v1.result;


import lombok.Data;
import me.hanwook.game.api.v1.param.CardsParam;
import me.hanwook.game.common.result.PagingResult;

import java.util.List;

@Data
public class CardsResult extends PagingResult {

    // 카드 목록
    private List<CardResult> list;

    public CardsResult() { }

    public CardsResult(CardsParam param, List<CardResult> list, Long totalCount) {
        this.size = param.getSize();
        this.offset = param.getOffset();
        this.totalCount = totalCount;
        this.list = list;
    }
}
