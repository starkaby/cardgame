package me.hanwook.game.api.v1.controller;

import me.hanwook.game.api.v1.param.UserRegistParam;
import me.hanwook.game.api.v1.param.UsersParam;
import me.hanwook.game.api.v1.result.UserResult;
import me.hanwook.game.api.v1.result.UsersResult;
import me.hanwook.game.api.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 사용자
 */
@RestController
@RequestMapping("/v1/users")
public class UserV1Controller {

    @Autowired
    private UserService userService;

    /**
     * 사용자 정보 조회
     * @param param
     * @return
     */
    @GetMapping
    public ResponseEntity<UsersResult> findUsers(UsersParam param) {

        UsersResult usersResult = userService.findUsers(param);

        // 끝 페이지
        if(usersResult.getTotalCount() <= (param.getOffset() + param.getSize())) {
            return new ResponseEntity<>(usersResult, null, HttpStatus.OK);
        }

        return new ResponseEntity<>(usersResult, null, HttpStatus.PARTIAL_CONTENT);
    }

    /**
     * 사용자 생성
     * @param param
     * @return
     */
    @PostMapping
    public ResponseEntity<UserResult> regist(@RequestBody UserRegistParam param) {

        UserResult userResult = userService.regist(param);

        return ResponseEntity.ok(userResult);
    }

    /**
     * 사용자 조회
     * @param userId
     * @return
     */
    @GetMapping("{userId}")
    public ResponseEntity<UserResult> get(@PathVariable("userId") Long userId) {

        UserResult user = userService.findUser(userId);

        return ResponseEntity.ok(user);
    }
}
