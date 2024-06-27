package com.example.todo.controller.task;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {

    private final DefaultErrorAttributes errorAttributes;

    public TaskController(DefaultErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @GetMapping("/tasks")
    public String list(Model model){
        //TaskDTOクラスを初期化して使っていく。
        var task1 = new TaskDTO(5,"Springbootを学ぶ", "aplliを作ってみる", "To Do2");
        var task2 = new TaskDTO(5,"SpringSecurityを学ぶ", "securityを作ってみる", "To Do2");

        var taskList = List.of(task1, task2);
        //２０行目で作った、Task(という名前にしたがTaskDTOクラスのインスタンス)インスタンスをaddAttributeで渡してあげる
        //第二引数のtaskは20行目のクラスインスタンスだよ。
        model.addAttribute("taskList", taskList);

        return "tasks/list";
    }
}
