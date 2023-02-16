package com.swacademy.mapcommunity.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "comment")
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int commentId;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(name = "comment_like")
    private int commentlike;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime commentDatetime;
    /**
     * fk
     */
//    @Column(name = "user_id")
//    private UUID userId;
//
//    @Column(name = "posted_id")
//    private UUID postedId;
}
