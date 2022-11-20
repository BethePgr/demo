package com.example.demo.rest;

import lombok.*;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/param")
public class RestParamController {

    @GetMapping("/user")
    public String userName(HttpServletRequest request){ //URL : /param/user?name=홍길동 일시에 홍길동을 어떻게 보내는가
        String name = request.getParameter("name");
        return String.format("당신의 이름은 %s입니다.",name);
    }

    @GetMapping("/user2")
    public String userName2(@RequestParam(required = false) String name, @RequestParam(value = "age", defaultValue = "10") int ageageage){
        //URL : /param/user?name=홍길동&age=12 일시에 홍길동을 어떻게 보내는가
        //변수이름을 바꾸고 싶을 때 @RequestParam("age")를 붙여준다.
        //url에 age값이 들어오지 않을경우, 기본값을 설정하고싶은 경우 defaultvalue를 붙여준다
        return String.format("당신의 이름은 %s님이고, 나이는 %d세입니다.",name,ageageage);
    }

    @GetMapping("/user3")
    public String user3(UserDTO userInfo){
        //이렇게 변수가 많을때는 dto로 만들어준다
        return String.format("당신의 이름은 %s님이고, 나이는 %d세이고, 주소는 %s이며, 키는 %.2fcm이며, 취미는 %s들이다.",
                userInfo.getName(),
                userInfo.getAge(),
                userInfo.getAddress(),
                userInfo.getHeight(),
                userInfo.getHobby());
    }

    @GetMapping("/user4/{userNum}")
    public String user4(@PathVariable int userNum){

        return String.format("회원번호는 %d입니다.", userNum);
    }

    @Getter//필수
    @Setter @ToString
    @NoArgsConstructor //dto에서는 @noarguconstructor 필수
    @AllArgsConstructor
    public static class UserDTO{
        private String name;
        private int age;
        private String address;
        private double height;
        private List<String> hobby;
    }
}
