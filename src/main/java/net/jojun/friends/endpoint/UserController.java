package net.jojun.friends.endpoint;

import net.jojun.friends.core.service.UserService;
import net.jojun.friends.domain.UserVO;
import net.jojun.friends.repository.UserRepository;
import oracle.ucp.proxy.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JOJUN.
 * Date: 2020-07-07
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService UserService;
    @Autowired
    UserRepository UserRepository;

    @GetMapping
    public String helloWorld(){
        return "HelloWorld";
    }

    @PostMapping("/AddUser")
    public ResponseEntity<UserVO> insertUser(UserVO user){
        System.out.println(user.toString());
        return new ResponseEntity<UserVO>(UserService.save(user), HttpStatus.OK);
    }
    @GetMapping("/selectAllUser")
    public ResponseEntity<List<UserVO>> selectAllUser(){
        List<UserVO> user = UserService.findAll();
        return new ResponseEntity<List<UserVO>>(user, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteUser")
    public ResponseEntity<UserVO> deleteUser(@RequestParam Integer idx){

        UserVO user = new UserVO();
        user.setIdx(idx);
        System.out.println(user.toString());

        UserService.delete(user);

        return new ResponseEntity<UserVO>(HttpStatus.OK);
    }

}
