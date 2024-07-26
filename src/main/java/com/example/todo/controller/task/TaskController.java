package com.example.todo.controller.task;

import com.example.todo.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String list(Model model){
        var taskList = taskService.find()
                .stream()
                .map(TaskDTO::toDTO)
                .toList();
        model.addAttribute("taskList", taskList );
        return "tasks/list";
    }

    @GetMapping("/{id}")
    public  String showDetail(@PathVariable("id")long taskId, Model model){
        var taskEntity = taskService.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found id =" + taskId));
        model.addAttribute("task", TaskDTO.toDTO(taskEntity));
        return "tasks/detail";
    }

    //GET /tasks/creationForm
    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute TaskForm form){
        return "tasks/form";
    }

    //ModelAttributeアノをつけると、modelの役目もifも担ってくれる下記は、リファクト前
    //public String showCreationForm(TaskForm form, Model model){
    //        if (form == null){
    //            form = new TaskForm(null,null,null);
    //        }
    //        model.addAttribute("taskForm", form);
    //        return "tasks/form";


    //POSTリクエストは二重登録を防ぐためのPRGパターンを忘れずに。redirect
    @PostMapping
    public String create(@Validated TaskForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return showCreationForm(form);
        }
        taskService.create(form.toEntity());
        return "redirect:/tasks";
    }
}
