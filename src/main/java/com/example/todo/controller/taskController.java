package com.example.todo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.domain.Task;
import com.example.todo.service.TaskService;

@RestController
@CrossOrigin
public class taskController {

	private TaskService service;

	public taskController(TaskService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		return new ResponseEntity<Task>(this.service.createTask(task), HttpStatus.CREATED);
	}


	@GetMapping("/get")
	public ResponseEntity<List<Task>> getTask() {
		return new ResponseEntity<List<Task>>(this.service.getTask(), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Task> updateTask(@PathParam("id") Integer id, @RequestBody Task task) {
		return new ResponseEntity<Task>(this.service.updateTask(task, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteTask(@PathVariable Integer id) {
		if (this.service.deleteTask(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
