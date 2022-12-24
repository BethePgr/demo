package com.example.demo.user.repository;

import com.example.demo.user.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired UserRepository repository;

    @Test
    @DisplayName("회원가입에 성공해야한다.")
    void registerTest() {
        // given
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("apple@gmail.com");
        userEntity.setPassword("12345");
        userEntity.setUsername("김두한");
        // when
        boolean flag = repository.register(userEntity);
        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("이메일이 중복되면 true가 리턴되어야한다")
    void existEmailTest() {
        // given
        String email = "apple@gmail.com";
        // when
        boolean flag = repository.existsByEmail(email);
        // then
        assertTrue(flag);
    }
    @Test
    @DisplayName("이메일 통해 회원정보 모두 조회")
    void findUserName() {
        // given
        String email = "apple@gmail.com";
        // when
        UserEntity user = repository.findUserByEmail(email);
        // then
        assertEquals("김두한",user.getUsername());
        assertNotNull(user);
        System.out.println(repository.findUserByEmail(email));
        System.out.println("Sgsdgd");
    }
}