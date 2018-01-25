package me.hanwook.game.api.v1.result;

import lombok.Data;
import me.hanwook.game.api.v1.param.UsersParam;
import me.hanwook.game.common.result.PagingResult;

import java.util.List;

@Data
public class UsersResult extends PagingResult {

    private List<UserResult> list;

    public UsersResult() { }

    public UsersResult(UsersParam param, List<UserResult> list, Long totalCount) {
        this.size = param.getSize();
        this.offset = param.getOffset();
        this.totalCount = totalCount;
        this.list = list;
    }
}
