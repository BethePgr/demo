package com.example.demo.todo.service;

import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.dto.TodoDto;
import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//역할 : 컨트롤러와 저장소 사이의 잡일 처리역할(데이터 가공)
@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;
    /*
        -할 일 목록조회 중간 처리
        1.컨트롤렁게 userId를 뺀 할 일 리스트를 전달한다.
        2.할 일 목록의 카운트를 세서 따로 추가해서 전달한다.
     */

    public FindAllDTO findAllServ(){

        return new FindAllDTO(repository.findAll());
    }


    public FindAllDTO createServ(final ToDo newTodo) {

        if(newTodo == null){
            log.warn("newTodo 는 널이면 안됨");
            throw new RuntimeException("newTodo cannot be null!");
        }
        boolean flag = repository.save(newTodo);
        if (flag) log.info("새로운 할 일 Id : {}이 저장됨",newTodo.getId());
        return flag ? findAllServ() : null;
    }

    public ToDo findOneServ(long id){
        return repository.findOne(id);
    }


    public FindAllDTO deleteServ(long id) {
        boolean flag = repository.remove(id);
        //삭제 실패한 경우
        if (!flag){
            log.warn("delete fail! not found id [{}]",id);
            throw new RuntimeException("delete fail!");
        }
        return findAllServ();
    }
}
