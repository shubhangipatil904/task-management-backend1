package com.example.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	 @Autowired
	    private TaskService taskService;

	    @GetMapping
	    public List<Task> getAllTasks() {
	        return taskService.getAllTasks();
	    }

	    @PostMapping
	    public Task createTask(@RequestBody Task task) {
	        return taskService.createTask(task);
	    }

	    @PutMapping("/{id}")
	    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
	        return taskService.updateTask(id, task);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteTask(@PathVariable Long id) {
	        taskService.deleteTask(id);
	    }
	}
