package com.swacademy.mapcommunity.domain;

import com.swacademy.mapcommunity.domain.entity.User;
import com.swacademy.mapcommunity.domain.repository.UserRepository;
import com.swacademy.mapcommunity.vo.Gender;
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
class UserRepositoryTest {

    @Autowired
    EntityManagerFactory emf;

    @Autowired
    UserRepository repository;

    @BeforeEach
    void setUp(){
        repository.deleteAll();
    }

    @Test
    @DisplayName("insert & select test")
    void testCustomer() {
        // Given
        User user = new User();
        user.setUserId(UUID.randomUUID());
        user.setEmail("hong@gmail.com");
        user.setPassword("1234!");
        user.setNickName("나는퉁퉁이");
        user.setGender(Gender.NONE);

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(user);

        transaction.commit();

        //Then
        User entity = entityManager.find(User.class, user.getUserId());
        log.info("hihi name: {} email: {}", entity.getNickName(), entity.getEmail());
    }
}