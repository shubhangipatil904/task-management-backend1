package com.example.taskmanagement.service;

import java.util.List;

import com.example.taskmanagement.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.taskmanagement.repository.TaskRepository;

@Service
public class TaskService {
	 @Autowired
	    private TaskRepository taskRepository;

	    public List<Task> getAllTasks() {
	        return taskRepository.findAll();
	    }

	    public Task createTask(Task task) {
	        return taskRepository.save(task);
	    }

	    public Task updateTask(Long id, Task taskDetails) {
	        Task task = taskRepository.findById(id).orElseThrow();
	        task.setTitle(taskDetails.getTitle());
	        task.setDescription(taskDetails.getDescription());
	        task.setCompleted(taskDetails.isCompleted());
	        return taskRepository.save(task);
	    }

	    public void deleteTask(Long id) {
	        taskRepository.deleteById(id);
	    }
	}