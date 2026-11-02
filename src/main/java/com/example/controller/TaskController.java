package com.example.controller;

import com.example.pojo.Task;
import com.example.service.TaskService;
import com.example.utils.Result;
import com.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public Result<List<Task>> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Result<Task> getTaskById(@PathVariable("id") Long id) {
        Task task = taskService.getById(id);
        if(task == null) {
            return Result.build(ResultCodeEnum.NOT_FIND, null);
        }
        return Result.ok(task);
    }

    @PutMapping("/{id}")
    public Result<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public Result<Task> deleteTask(@PathVariable("id") Long id) {
        boolean isDeleted = taskService.removeById(id);
        if(!isDeleted) {
            return Result.build(ResultCodeEnum.NOT_FIND, null);
        }
        return Result.ok(null);
    }

}
