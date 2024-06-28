package com.example.todo.controller.task;

import com.example.todo.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @GetMapping("/tasks")
    public String list(Model model){
        //２０行目で作った、Task(という名前にしたがTaskDTOクラスのインスタンス)インスタンスをaddAttributeで渡してあげる
        //第二引数のtaskServiceのfind()の結果を入れるという事
        var taskList = taskService.find() //List<TaskEntity>->ListDTOに変換する
                .stream()
                        .map(TaskDTO::toDTO)
                                .toList();
        model.addAttribute("taskList", taskList );
        return "tasks/list";
    }
}
