package com.example.demo.todo.dto;


import com.example.demo.todo.entity.ToDo;
import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
//민감한 정보는 없음, 클라이언트에게 전달하고 싶은 데이터들만 존재
//이게 바로 entity.ToDo와의 차이
public class TodoDto {

    private long id;
    private String title;
    private boolean done;

    //ToDo에서 dto가 필요한 필드를 빼오는 생성자
    public TodoDto(ToDo toDo) {
        this.id = toDo.getId();
        this.title = toDo.getTitle();
        this.done = toDo.isDone();
    }
}
