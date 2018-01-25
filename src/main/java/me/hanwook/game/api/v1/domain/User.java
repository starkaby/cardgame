package me.hanwook.game.api.v1.domain;

import lombok.Data;
import me.hanwook.game.api.v1.param.UserRegistParam;

import javax.persistence.*;

/**
 * 사용자
 */
@Entity
@Table(name="t_users")
@Data
public class User {
    // 일련번호
    @Id
    @GeneratedValue
    private Long id;

    // 아이디
    @Column(length=30, nullable=false, unique=true)
    private String userId;

    // 이름
    @Column(length=255, nullable=false)
    private String userName;

    public User() { }

    public User(UserRegistParam param) {
        this.userId = param.getUserId();
        this.userName = param.getUserName();
    }
}
