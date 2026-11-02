package com.example.service;

import com.baomidou.mybatisplus.spring.service.IService;
import com.example.pojo.Project;
import com.example.utils.Result;

import java.util.List;

/**
 * @author zhiji
 * @createDate 2026-11-02 08:32:24
 */
public interface ProjectService extends IService<Project> {
    Result<Project> createNewProject(Project project);
    Result<List<Project>> getAllProjects();
    Result<Project> updateProject(Long id, Project project);
}
