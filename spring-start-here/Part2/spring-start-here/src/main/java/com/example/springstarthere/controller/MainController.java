package com.example.springstarthere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    /**
     * @RequestParam : 요청 매개변수를 통해 값 주입
     * -> 메서드 매개변수 이름과 동일한 이름을 가진 HTTP 요청 매개변수에서 값을 가져와야 한다고 알리는 어노테이션
     * -> 즉, HTTP 요청에 있는 파라미터에서 매개변수명과 같은 키를 가진 값을 가져온다
     * -> required = false : 매개변수는 기본적으로 필수이기 때문에 다음과 같은 옵션을 추가하면 필수가 아님
     * http://localhost:8080/home?color=blue&name=제인
     * -> 요청 매개변수는 URL?[키1=값1&키2=값2]
     * 뷰에 보낼 데이터를 저장하기 위해 "Model" 클래스를 사용
     */
    @RequestMapping("/home")
    public String homeParam(
        @RequestParam(required = false) String color,
        @RequestParam(required = false) String name,
        Model page) {

        /**
         * 뷰에 보낼 데이터 추가
         */
        page.addAttribute("username", name);
        page.addAttribute("color", color);

        return "home";

    }

    /**
     * @PathVariable : 경로 매개변수를 통해 값 주입
     * -> 경로 변수의 값을 가져오기 위한 어노테이션
     * -> 경로 변수는 uri에 {pathvariable}과 같이 추가하여 이를 매개변수명과 일치시켜 주입
     */
    @RequestMapping("/home/{color}/{name}")
    public String homePath(
        @PathVariable String color,
        @PathVariable String name,
        Model page) {

        /**
         * 뷰에 보낼 데이터 추가
         */
        page.addAttribute("username", name);
        page.addAttribute("color", color);

        return "home";

    }

}
