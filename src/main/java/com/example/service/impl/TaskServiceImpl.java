package com.example.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.pojo.Task;
import com.example.service.TaskService;
import com.example.mapper.TaskMapper;
import org.springframework.stereotype.Service;

/**
* @author zhiji
* @createDate 2026-11-02 08:32:24
*/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService{

}




