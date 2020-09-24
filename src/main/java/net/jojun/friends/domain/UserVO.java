package net.jojun.friends.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by JOJUN.
 * ORACLE - JPA 연습 VO
 * Date: 2020-07-07
 */
//  @Entitiy : JPA가 관리하는 클래스를 의미, @Id PK 지정,
//  @NoArgsConstructor : Lombok 어노테이션 , 파라미터가 필요없는 생성자를 생성. @AllArgsConstructor : Lombok 어노테이션 , 모든 필드를 파라미터로 갖는 생성자
//  @Data : Lombok 어노테이션, GETTER , SETTER , toString 자동으로 생성
@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class UserVO {


    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)

    /*
       .SEQUENCE를 사용해야겠다고 생각한 이유 ?

        삭제를 할 때 이름은 중복이 있을수 있다
        -> PK가 고유한 값 ( 값은 사용자가 알필요 X )
        -> INDEX 추가
        -> .AUTO 시퀀스 오류 왜? 시퀀스를 찾을 수 없다.
        -> .SEQUENCE 로 DB에서 시퀀스를 만들어서 해결
        -> .AUTO 와 .SEQUENCE 의 차이 ?

        .AUTO : JPA 구현체가 자동으로 생성 전략을 결정한다.
        .SEQUENCE :데이터베이스의 특별한 오브젝트 시퀀스를 사용하여 기본키를 생성한다.
        무슨 차이인가 ? 결국 하나의 시퀀스로 일정 값을 증가시켜가며 관리하는것 아닌가?

     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDX_SEQ_GENERATOR")
    @SequenceGenerator(name = "IDX_SEQ_GENERATOR", sequenceName = "USERS_SEQ01",
            initialValue = 1, allocationSize = 1)
    private int idx;

    private String name;
    private int age;
    private String locale;

}

