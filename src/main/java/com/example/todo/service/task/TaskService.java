package com.example.todo.service.task;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {

    public List<TaskEntity> find(){

        //TaskDTOクラスを初期化して使っていく。
        var task1 = new TaskEntity(5,"Springbootを学ぶ", "aplliを作ってみる", TaskStatus.TODO);
        var task2 = new TaskEntity(5,"SpringSecurityを学ぶ", "securityを作ってみる", TaskStatus.DOING);

        return List.of(task1, task2);
    }
}
