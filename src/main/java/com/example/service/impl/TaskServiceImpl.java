package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.mapper.ProjectMapper;
import com.example.pojo.Project;
import com.example.pojo.Task;
import com.example.pojo.TaskStatus;
import com.example.service.TaskService;
import com.example.mapper.TaskMapper;
import com.example.utils.Result;
import com.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author zhiji
* @createDate 2026-11-02 08:32:24
*/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService{

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public Result<Task> createTaskProject(Long projectId, Task task) {
        task.setProjectId(projectId);
        task.setStatus(TaskStatus.TODO);
        taskMapper.insert(task);
        return Result.ok(null);
    }

    @Override
    public Result<List<Task>> getAllTasks() {
        List<Task> taskList = taskMapper.selectList(null);
        return Result.ok(taskList);
    }

    @Override
    public Result<Task> updateTask(Long id, Task task) {
        Task oldTask = taskMapper.selectById(id);
        if(oldTask == null) {
            return Result.build(ResultCodeEnum.NOT_FIND, null);
        }
        if(task.getTitle() != null) oldTask.setTitle(task.getTitle());
        if(task.getDescription() != null) oldTask.setDescription(task.getDescription());
        if(task.getStatus() != null) oldTask.setStatus(task.getStatus());
        taskMapper.updateById(oldTask);

        return Result.ok(null);
    }
}




