package com.example.demo.ibatis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestRepositoryTest {

    @Autowired
    TestRepository repository;

    @Test
    @DisplayName("유저이름과 나이가 tbl_test테이블에 저장되어야한다.")
    void saveTest() {
        // given
        TestEntity entity = new TestEntity();
        entity.setUsername("김영자");
        entity.setAge(23);
        // when
        boolean flag = repository.save(entity);
        // then
        assertTrue(flag);
        assertNotNull(entity.getId());
    }

    @Test
    @DisplayName("유저이름과 나이를 수정해야한다.")
    void modifyTest() {
        // given
        TestEntity entity = new TestEntity();
        entity.setUsername("고수정");
        entity.setAge(250);
        entity.setId("9c94b292-e73c-4bb9-9bb6-fb64e69e01ec");
        // when
        boolean flag = repository.modify(entity);
        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("유저를 지움")
    @Transactional
    @Rollback
    void deleteTest() {
        // given
        String id = "9c94b292-e73c-4bb9-9bb6-fb64e69e01ec";
        // when
        boolean flag = repository.remove(id);
        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("모든 목록을 조회")
    void findAllTest() {
        // given

        // when
        List<TestEntity> entityList = repository.findAll();
        // then
        System.out.println(entityList);
        assertEquals(4,entityList.size());
    }
}