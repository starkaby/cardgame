package me.hanwook.game.api.v1.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import me.hanwook.game.api.v1.domain.QUser;
import me.hanwook.game.api.v1.domain.User;
import me.hanwook.game.api.v1.param.UserRegistParam;
import me.hanwook.game.api.v1.param.UsersParam;
import me.hanwook.game.api.v1.repository.UserRepository;
import me.hanwook.game.api.v1.result.UserResult;
import me.hanwook.game.api.v1.result.UsersResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자 서비스
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 사용자 목록 조회
     * @param param
     * @return
     */
    public ResponseEntity<UsersResult> findUsers(UsersParam param) {

        // jpa Query 생성
        QUser user = QUser.user;
        JPAQuery<User> jpaQuery = new JPAQuery(entityManager);

        // where
        JPAQuery<User> jpaQueryWhere = jpaQuery.from(user).where(user.userId.like("%" + param.getSearchValue() + "%"));

        // count
        Long totalCount = jpaQueryWhere.fetchCount();

        // list
        List<User> list = jpaQueryWhere.offset(param.getOffset()).limit(param.getSize()).fetch();

        // 결과상태로 변경
        List<UserResult> userResults = list.stream().map(UserResult::new).collect(Collectors.toList());

        // 끝 페이지
        if(totalCount <= (param.getOffset() + param.getSize())) {
            return new ResponseEntity<>(new UsersResult(param, userResults, totalCount), null, HttpStatus.OK);
        }

        return new ResponseEntity<>(new UsersResult(param, userResults, totalCount), null, HttpStatus.PARTIAL_CONTENT);
    }

    /**
     * 사용자 생성
     * @param param
     * @return
     */
    public ResponseEntity<UserResult> regist(UserRegistParam param) {

        QUser user = QUser.user;
        JPAQuery<User> jpaQuery = new JPAQuery(entityManager);

        // 중복 수 확인
        Long duplicateCount = jpaQuery.from(user).where(user.userId.eq(param.getUserId())).fetchCount();

        if(duplicateCount > 0) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        // 신규 사용자 생성
        User newUser = userRepository.save(new User(param));

        return new ResponseEntity<>(new UserResult(newUser), null, HttpStatus.CREATED);
    }

    /**
     * 사용자 조회
     * @param userId
     * @return
     */
    public UserResult findUser(Long userId) {
        User user = userRepository.findOne(userId);

        if(user == null) {
            return null;
        }

        return new UserResult(user);
    }
}
