package com.swacademy.mapcommunity.domain.repository;


import com.swacademy.mapcommunity.domain.entity.Comment;
import com.swacademy.mapcommunity.domain.entity.Post;
import com.swacademy.mapcommunity.domain.entity.User;
import com.swacademy.mapcommunity.vo.Gender;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@SpringBootTest
public class associationMappingTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    @DisplayName("User-Post 연관관계 test")
    void userPostTest() {

        User user = new User();
        user.setUserId(UUID.randomUUID());
        user.setEmail("hong@gmail.com");
        user.setGender(Gender.NONE);
        user.setPassword("1234!!");
        user.setNickName("honghong");

        userRepository.save(user);

        Post post = new Post();
        post.setTitle("test post");
        post.setContent("this is test post");
        post.setPostDatetime(LocalDateTime.now());

        post.setUser(user);    //연관관계 편의 메소드

        postRepository.save(post);
//        Post postEntity = entityManager.find(Post.class, user.getId());
//        log.info("postEntity: {}", postEntity.getUser().getNickName());
//        log.info("{}", post.getUser().getPosts().size());
    }

    @Test
    @DisplayName("Post-Comment 연관관계 test")
    void postCommentTest() {
        Post post = new Post();
        post.setTitle("test");
        post.setContent("this is post comment association test");

        postRepository.save(post);

        Comment comment = new Comment();
        comment.setContent("post comment test");

        comment.setPost(post);

        commentRepository.save(comment);
    }

    @Test
    @DisplayName("User-Comment 연관관계 test")
    void userCommentTest() {
        User user = new User();
        user.setUserId(UUID.randomUUID());
        user.setNickName("yesyes");
        user.setPassword("yes1234!");
        user.setEmail("yes@gmail.com");

        userRepository.save(user);

        Comment comment = new Comment();
        comment.setContent("this is userComment association");
        comment.setUser(user);

        commentRepository.save(comment);

    }
}
