package com.swacademy.mapcommunity.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "comment")
@Getter
@Setter
public class Comment {

    @Id
    @Column(name = "comment_id")
    private UUID commentId;

    @Column(nullable = false)
    private String content;

    @Column(name = "comment_like")
    private int commentlike;


    /**
     * fk
     */
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "posted_id")
    private Long postedId;
}
