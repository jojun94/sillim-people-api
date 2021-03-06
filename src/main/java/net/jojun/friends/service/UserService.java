package net.jojun.friends.service;

import net.jojun.friends.domain.UserVO;

import java.util.List;

/**
 * Created by JOJUN.
 * Date: 2020-07-07
 */
public interface UserService {
    public List<UserVO> findAll();

    public List<UserVO> findByName(String name);

    public List<UserVO> findByAge(int age);

    public UserVO save(UserVO user);

    public void deleteById(int idx);
}
