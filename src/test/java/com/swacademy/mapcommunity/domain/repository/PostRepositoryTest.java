package com.swacademy.mapcommunity.domain.repository;

import com.swacademy.mapcommunity.domain.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@Slf4j
@SpringBootTest
class PostRepositoryTest {
    @Autowired
    EntityManagerFactory emf;

    @Autowired
    PostRepository repository;

    @BeforeEach
    void setUp(){
        repository.deleteAll();
    }

    @Test
    @DisplayName("insert & select test")
    void testCustomer() {
        // Given
        Post post = new Post();
        post.setTitle("처음으로 써보는 글");
        post.setContent("우와 처음으로 글이 써진다!!");

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(post);

        transaction.commit();

        //Then
        Post entity = entityManager.find(Post.class, post.getPostId());
        log.info("hihi name: {} email: {}", entity.getTitle(), entity.getContent());
        System.out.println("좋아요 수 "+entity.getPostLike());
        System.out.println("좋아요 수 "+entity.getPostLike()+10);
    }
}