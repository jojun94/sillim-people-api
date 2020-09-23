package net.jojun.friends.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by JOJUN.
 * Date: 2020-07-07
 */
//  @Entitiy : JPA가 관리하는 클래스를 의미, @Id PK 지정,
@Data
@Entity(name="users")
@Table(name="users")
public class UserVO {



    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDX_SEQ_GENERATOR")
    @SequenceGenerator(name = "IDX_SEQ_GENERATOR", sequenceName = "USERS_SEQ01",
            initialValue = 1, allocationSize = 1)
    private int idx;

    private String name;
    private int age;
    private String locale;

    // 기본생성자는 public 또는 protectec ,
    // private 으로 사용 시 추후에 Lazy Loading 사용 시 Proxy 관련 예외가 발생
    public UserVO(){

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLocale() {
        return locale;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
    }
    /*@Builder
    public UserVO(String name, int age){
        this.name = name;
        this.age = age;
    }*/
}

