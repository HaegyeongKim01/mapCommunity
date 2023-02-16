package com.swacademy.mapcommunity.domain.repository;

import com.swacademy.mapcommunity.domain.entity.Comment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    EntityManagerFactory emf;

    @Autowired
    UserRepository repository;

    @BeforeEach
    void setUp(){
        repository.deleteAll();
    }

    @Test
    @DisplayName("comment insert test")
    void insertTest() {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Comment comment = new Comment();
        comment.setContent("this is first comment");
        comment.setCommentlike(0);
//        comment.setUserId(UUID.randomUUID());
//        comment.setPostedId(UUID.randomUUID());

        transaction.begin();

        entityManager.persist(comment);

        transaction.commit();

    }

}