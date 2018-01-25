package me.hanwook.game.api.v1.param;

import lombok.Data;
import me.hanwook.game.common.param.Param;

/**
 * 사용자 생성 파라미터
 */
@Data
public class UserRegistParam extends Param {

    // 사용자 아이디
    private String userId;

    // 사용자 명
    private String userName;

}
