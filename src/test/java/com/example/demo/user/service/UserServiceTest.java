package com.example.demo.user.service;

import com.example.demo.user.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired UserService userService;

    @Test
    @DisplayName("회원가입 되지 않은 이메일을 사용해 로그인하면 예외가 발생한다.")
    void loginTest1() {
        // given
        String email = "1@naver.com";
        // when

        // then
        assertThrows(RuntimeException.class, () ->{
            userService.validateLogin(email,"");
        });
    }

    @Test
    @DisplayName("로그인이 성공하면 회원정보가 리턴된다.")
    void loginTest2() {
        // given
        String email = "1@naver.com";
        String password = "12345";
        // when
        UserEntity user = userService.validateLogin(email, password);
        // then
        assertNotNull(user);
        assertEquals(email, user.getEmail());
    }

}