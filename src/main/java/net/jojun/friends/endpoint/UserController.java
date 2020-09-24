package net.jojun.friends.endpoint;

import net.jojun.friends.service.UserService;
import net.jojun.friends.domain.UserVO;
import net.jojun.friends.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JOJUN.
 * REST API SERVER의 CRUD 연습 Controller , JPA 연습
 * Date: 2020-07-07
 */
//TODO : BEAN 의존성 주입의 3가지 방법 알아보기
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String helloWorld(){
        return "HelloWorld";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserVO> insertUser(@RequestBody UserVO user){
        userService.save(user);
        return new ResponseEntity<UserVO>(user, HttpStatus.OK);
    }

    @GetMapping("/user/list")
    public ResponseEntity<List<UserVO>> selectAllUser(){

        List<UserVO> users = userService.findAll();

        return new ResponseEntity<List<UserVO>>(users, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<UserVO> deleteUser(@RequestParam Integer idx){
        userRepository.deleteById(idx);
        return new ResponseEntity<UserVO>(HttpStatus.OK);
    }

    // REST
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "id") int idx) {
        userRepository.deleteById(idx);;
    }
}
