package me.hanwook.game.api.v1.param;

import lombok.Data;
import me.hanwook.game.common.param.PagingParam;

/**
 * 사용자 목록 검색 파라미터
 */
@Data
public class UsersParam extends PagingParam {

    // 검색 값
    private String searchValue = "";
}
