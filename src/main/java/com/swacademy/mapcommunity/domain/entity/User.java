package com.swacademy.mapcommunity.domain.entity;

import com.swacademy.mapcommunity.vo.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    //@Todo ADD unique
    @Column(name = "nick_name", nullable = false, length = 30)
    private String nickName;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    //@Todo - birth 추가
    private LocalDate birth;

}
