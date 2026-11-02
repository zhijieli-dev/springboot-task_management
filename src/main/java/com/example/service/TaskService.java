package com.example.service;

import com.baomidou.mybatisplus.spring.service.IService;
import com.example.pojo.Task;
import com.example.utils.Result;

import java.util.List;

/**
* @author zhiji
* @createDate 2026-11-02 08:32:24
*/
public interface TaskService extends IService<Task> {
    Result<Task> createTaskProject(Long projectId, Task task);
    Result<List<Task>> getAllTasks();
    Result<Task> updateTask(Long id, Task task);
}
