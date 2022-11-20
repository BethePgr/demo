package com.example.demo.todo.entity;

import lombok.*;

@Setter @Getter @ToString
//@NoArgsConstructor
@AllArgsConstructor
//db에 고대로 들어갈 데이터 그 자체(민감한 정보 싹 다 포함 왜냐, 데이터베이스에도 있어야할 데이터니까)
//역할 : 하나의 할 일 데이터의 집합 객체다.
public class ToDo {
    private Long id;//할 일들을 식별하는 번호
    private String userId;//할 일을 등록한 회원의 식별자
    private String title;//할 일 내용
    private boolean done;//할 일 완료 여부

    //일련번호
    private static long seq;

    public ToDo() {
        this.id = ++seq;
    }

    public ToDo(String title) {
        this(); // 나의 기본 생성자 호출 (ToDo()를 호출하게된다.)
        this.title = title;
        this.userId = "noname";

    }
}
