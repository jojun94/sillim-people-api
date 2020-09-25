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
//  BEAN 의존성 주입의 3가지 방법 -> git 에 기록
//  생성자 주입을 통한 의존성 주입을 권장
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    /* Spring 4.3부터는 클래스의 생성자가 하나이고 그 생성자로 주입받을 객체가 빈으로 등록되어 있다면 생성자 주입에서 @Autowired를 생략할 수 있다 */
//    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

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
        userService.deleteById(idx);
        return new ResponseEntity<UserVO>(HttpStatus.OK);
    }

    // REST
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "id") int idx) {
        userService.deleteById(idx);;
    }
}
