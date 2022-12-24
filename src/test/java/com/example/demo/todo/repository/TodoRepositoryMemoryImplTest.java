package com.example.demo.todo.repository;

import com.example.demo.todo.entity.ToDo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //스프링 컨테이너를 테스트 클래스에서 사용가능
class TodoRepositoryMemoryImplTest {

    @Autowired
    TodoRepository repository;

    //단언(강력하게 주장)해야함
//    @Test
//    @DisplayName("저장소에서 목록을 조회했을 때 할 일의 갯수가 3개여야 한다.")
//    void findAllTest(){
//        //given : 테스트 시 필요한 데이터
//
//        //when : 테스트의 실제 상황
//        List<ToDo> toDoList = repository.findAll();
//        //then : 테스트의 결과
//        assertEquals(3,toDoList.size());
//        assertNotNull(toDoList);
//    }

//    @Test
//    @DisplayName("아이디가 2번인 할 일 데이터를 조회했을 때 그 작성자의 이름이 박영희여야 한다.")
//    void findOneTest(){
//        //given
//        long id = 2L;
//        //when
//        ToDo todo = repository.findOne(id);
//        //then
//        assertEquals("박영희",todo.getUserId());
//        assertFalse(todo.isDone());
//    }

//    @Test
//    @DisplayName("1번 할일을 삭제한 후 다시 조회했을 때 null이 나와야 한다")
//    void removeTest(){
//        // given
//        long id = 1L;
//        // when
//        boolean flag = repository.remove(id);
//        ToDo todo = repository.findOne(id);
//        // then
//        assertTrue(flag);
//        assertNull(todo);
//        assertEquals(2,repository.findAll().size());
//    }
//
//    @Test
//    @DisplayName("4,김철수,저녁밥 만들기,false 추가 시 목록 개수 4개여야한다.")
//    void saveTest() {
//        // given
//        ToDo todo = new ToDo(4L,"김철수","밥 만들기",false);
//        // when
//        boolean flag = repository.save(todo);
//        // then
//        assertEquals(4,repository.findAll().size());
//        assertTrue(flag);
//    }


}