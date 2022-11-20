package com.example.demo.todo.api;

import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.dto.TodoDto;
import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.repository.TodoRepository;
import com.example.demo.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/todos")
@RequiredArgsConstructor //inal이 붙은 필드가 포함된 생성자를 만들어주는 어노테이션, 밑에 autowire된 생성자랑 똑같은 기능을 한다
public class TodoApiController {
    private final TodoService service;

//    @Autowired
//    public TodoApiController(TodoRepository repository) {
//        this.repository = repository;
//    }

    //할 일 목록 전체조회 요청
    @GetMapping
    public FindAllDTO todos(){
        log.info("/api/todos GET request!");
        return service.findAllServ();
    }

    //할 일 목록 등록 요청
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ToDo newTodo){
        newTodo.setUserId("noname");
        log.info("/api/todos POST request! -{}",newTodo);

        try {
            FindAllDTO dto = service.createServ(newTodo);

            if (dto == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    //할 일 개별 조회 요청
    //uri : /api/todos/2 => 2번 할 일을 조회해서 클라이언트에게 리턴
    //ToDo 타입으로 보낸 경우
    @GetMapping("/2")
    public ToDo findOneDo(){
        log.info("/api/todos/2 GET request");
        return service.findOneServ(2);
    }

    //TodoDto로 보낸 경우 3번할일을 조회해준다




    //할 일 삭제 요청
    //uri : /api/todos/3 => 3번 할 일을 삭제 후 삭제된 이후 갱신된 할일 목록 리스트를 리턴
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        log.info("/api/todos/{} DELETE request!",id);

        try {
            FindAllDTO dtos = service.deleteServ(id);
            return ResponseEntity.ok().body(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}
