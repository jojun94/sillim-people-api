package net.jojun.friends.repository;

import net.jojun.friends.domain.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JOJUN.
 * Date: 2020-07-07
 */

@Repository
public interface UserRepository extends JpaRepository<UserVO, Integer> {

    public List<UserVO> findByName(String name);

    public List<UserVO> findByAge(int age);

}

