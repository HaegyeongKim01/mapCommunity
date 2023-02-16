package com.swacademy.mapcommunity.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "post")
@Getter
@Setter
@DynamicInsert
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postId;

    @Column(nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime postDatetime;

    /**
     * like는 SQL 예약어이기에 오류 가능성 높음
     * default로 0으로 하기
     */
    @ColumnDefault("0")
    private int postLike;

    //@Todo post_date

    @Column(columnDefinition = "GEOMETRY")
    private Point geography;

    //@Todo fk
    /*
    @Column(name = "user_id")
    private long userId;
    */
}
