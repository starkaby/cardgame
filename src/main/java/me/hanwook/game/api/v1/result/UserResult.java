package me.hanwook.game.api.v1.result;

import lombok.Data;
import me.hanwook.game.api.v1.domain.User;
import me.hanwook.game.common.result.Result;

/**
 * 사용자 목록조회 결과
 */
@Data
public class UserResult extends Result {

    private Long id;
    private String userName;

    public UserResult() { }

    public UserResult(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
    }
}
