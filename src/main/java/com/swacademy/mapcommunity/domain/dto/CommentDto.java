package com.swacademy.mapcommunity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long commentId;
    private String content;
    private int commentLike;
    private LocalDateTime commentDatetime;

    private PostDto postDto;
    private UserDto userDto;
}
