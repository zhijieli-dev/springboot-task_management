package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.pojo.Project;
import com.example.service.ProjectService;
import com.example.mapper.ProjectMapper;
import com.example.utils.Result;
import com.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author zhiji
* @createDate 2026-11-02 08:32:24
*/
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService{

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public Result<Project> createNewProject(Project project) {
        projectMapper.insert(project);
        return Result.ok(null);
    }

    @Override
    public Result<List<Project>> getAllProjects() {
        List<Project> projectList = projectMapper.selectList(null);
        return Result.ok(projectList);
    }

    @Override
    public Result<Project> updateProject(Long id, Project project) {
        LambdaUpdateWrapper<Project> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Project::getId, id);
        int row = projectMapper.update(project, updateWrapper);
        if(row > 0) {
            return Result.ok(null);
        }
        return Result.build(ResultCodeEnum.NOT_FIND, null);
    }
}




