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

    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @Override
    public List<UserVO> findAll() {

        List<UserVO> users = userRepository.findAll();
        return users;
    }

    @Override
    public List<UserVO> findByName(String name) {

        List<UserVO> users =  userRepository.findByName(name);
        return users;
    }

    @Override
    public List<UserVO> findByAge(int age) {

        List<UserVO> users =  userRepository.findByAge(age);
        return users;
    }

    @Override
    public UserVO save(UserVO user) {

        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteById(int idx) {
        userRepository.deleteById(idx);
    }


}
