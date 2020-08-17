package net.jojun.sillimpeople.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by JOJUN.
 * Date: 2020-07-07
 */
//  @Entitiy : JPA가 관리하는 클래스를 의미, @Id PK 지정,
@Data
@Entity(name="users")
public class UserVO {

    /*@GeneratedValue(strategy = GenerationType.AUTO)
    private int rnum;*/
    @Id
    private String name;
    private int age;
    private String locale;
    // 기본생성자는 public 또는 protectec ,
    // private 으로 사용 시 추후에 Lazy Loading 사용 시 Proxy 관련 예외가 발생
    protected UserVO(){

    }

    /*@Builder
    public UserVO(String name, int age){
        this.name = name;
        this.age = age;
    }*/
}

