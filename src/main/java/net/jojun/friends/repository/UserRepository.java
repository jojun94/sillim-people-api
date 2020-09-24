package net.jojun.friends.repository;

import net.jojun.friends.domain.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JOJUN.
 * JPA 연습 REPOSITORY
 * Date: 2020-07-07
 */
// @REPOSITORY 없어도 되는 이유 : JpaRepository -> ... -> Repository 를 상속받았기 때문에

public interface UserRepository extends JpaRepository<UserVO, Integer> {

    public List<UserVO> findByName(String name);

    public List<UserVO> findByAge(int age);

}

