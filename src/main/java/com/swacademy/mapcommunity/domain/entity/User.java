package com.swacademy.mapcommunity.domain.entity;

import com.swacademy.mapcommunity.vo.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    private UUID userId;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nick_name", nullable = false, length = 30, unique = true)
    private String nickName;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    //@Todo - birth 추가
}
