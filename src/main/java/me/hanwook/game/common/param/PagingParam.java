package me.hanwook.game.common.param;

import lombok.Data;

/**
 * 페이징 파라미터
 */
@Data
public class PagingParam extends Param {

    // 오프셋
    private Integer offset = 0;

    // 수
    private Integer size = 10;
}
