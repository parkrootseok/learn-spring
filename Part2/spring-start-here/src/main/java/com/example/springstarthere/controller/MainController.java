package com.example.springstarthere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Controller : MainController를 Bean으로 등록하기 위한 스테레오타입 주석
 */
@Controller
public class MainController {

    /**
     * @RequestMapping("uri") : http 요청과 메소드를 연결
     */
    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }

}
