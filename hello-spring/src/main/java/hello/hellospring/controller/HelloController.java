package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Controller는 반드시 해당 어노테이션 선언
public class HelloController {

    @GetMapping("hello")    // "/hello"로 들어온 요청에 아래 Method 실행
    public String hello(Model model) {
        model.addAttribute("data", "ParkRootSeok");
        return "hello";
    }
}
