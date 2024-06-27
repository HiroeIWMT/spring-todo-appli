package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class indexController {
    //localhost:8080にアクセスしたら、"hello world"と表示されるコントローラーを作る
    @GetMapping
    public String indexcccccccc(){
        return "index";
        //indexはテンプレート名だよ！
    }
}
