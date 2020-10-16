package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.domain.Task;
import com.example.todo.domain.TaskRepo;

@Service
public class TaskService {

	private TaskRepo repo;

	public TaskService(TaskRepo repo) {
		super();
		this.repo = repo;
	}

	public List<Task> getTask() {
		return this.repo.findAll();
	}

	public Task createTask(Task task) {
		return this.repo.save(task);
	}

	public Task updateTask(Task task, Integer id) {
		Task oldTask = this.repo.findById(id).get();

		oldTask.setDescription(task.getDescription());

		return this.repo.save(oldTask);
	}

	public Task completeTask(Integer id) {

		Task newTask = this.repo.findById(id).get();
		newTask.setCompleted(true);

		return this.repo.save(newTask);
	}

	public boolean deleteTask(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
