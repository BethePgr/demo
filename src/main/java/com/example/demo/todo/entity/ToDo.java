package com.example.demo.todo.entity;

import lombok.*;

@Setter @Getter @ToString @NoArgsConstructor @AllArgsConstructor
//역할 : 하나의 할 일 데이터의 집합 객체다.
public class ToDo {
    private Long id;//할 일들을 식별하는 번호
    private String userId;//할 일을 등록한 회원의 식별자
    private String title;//할 일 내용
    private boolean done;//할 일 완료 여부
}
