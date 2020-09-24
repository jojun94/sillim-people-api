package net.jojun.friends.service.impl;

import net.jojun.friends.service.UserService;
import net.jojun.friends.domain.UserVO;
import net.jojun.friends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOJUN.
 * Date: 2020-07-07
 */
@Service
public class UserServiceImp implements UserService {
    //TODO : BEAN 의존성 주입의 3가지 방법 알아보기 , DELETE 정리

    @Autowired
    UserRepository UserRepository;

    @Override
    public List<UserVO> findAll() {
        List<UserVO> users = new ArrayList<>();
        UserRepository.findAll().forEach(e -> users.add(e));

        return users;
    }

    @Override
    public List<UserVO> findByName(String name) {
        List<UserVO> users = new ArrayList<>();
        UserRepository.findByName(name).forEach(e -> users.add(e));
        return users;
    }

    @Override
    public List<UserVO> findByAge(int age) {
        List<UserVO> users = new ArrayList<>();
        UserRepository.findByAge(age).forEach(e -> users.add(e));
        return users;
    }

    @Override
    public UserVO save(UserVO user) {
        UserRepository.save(user);
        return user;
    }



}
