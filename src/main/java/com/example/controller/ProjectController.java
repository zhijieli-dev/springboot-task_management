package com.example.controller;

import com.example.pojo.Project;
import com.example.pojo.Task;
import com.example.service.ProjectService;
import com.example.service.TaskService;
import com.example.utils.Result;
import com.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Result<Project> createNewProject(@RequestBody Project project) {
        return projectService.createNewProject(project);
    }

    @GetMapping
    public Result<List<Project>> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Result<Project> getProject(@PathVariable("id") Long id) {
        Project project = projectService.getById(id);
        if(project != null) {
            return Result.ok(project);
        }
        return Result.build(ResultCodeEnum.NOT_FIND, null);
    }

    @PutMapping("/{id}")
    public Result<Project> updateProject(@PathVariable("id") Long id, @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("/{id}")
    public Result<Project> deleteProject(@PathVariable("id") Long id) {
         boolean isDeleted = projectService.removeById(id);
         if(isDeleted) {
             return Result.ok(null);
         }
         return Result.build(ResultCodeEnum.NOT_FIND, null);
    }

    @PostMapping("/{projectId}/tasks")
    public Result<Task> createTaskProject(@PathVariable("projectId") Long projectId, @RequestBody Task task) {
        Project project = projectService.getById(projectId);
        if(project == null) {
            return Result.build(ResultCodeEnum.NOT_FIND, null);
        }
        return taskService.createTaskProject(projectId, task);
    }

}
