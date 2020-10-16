package com.example.todo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.todo.domain.Task;
import com.example.todo.domain.TaskRepo;

@SpringBootTest
public class TodoServiceUnitTest {

	@Autowired
	private TaskService service;

	@MockBean
	private TaskRepo repo;

	@Test
	void testCreate() {

		// GIVEN
		Integer id = 2;

		Task newTask = new Task("Go to the gym");
		Task savedTask = new Task("Go to the gym");
		savedTask.setId(id);

		// WHEN
		Mockito.when(this.repo.save(newTask)).thenReturn(savedTask);

		// THEN
		assertThat(this.service.createTask(newTask)).isEqualTo(savedTask);
	}

	@Test
	void testUpdate() {

		// GIVEN
		Integer id = 2;

		Task newTask = new Task("Go home then shopping");

		Task oldTask = new Task("Go shopping then home");
		oldTask.setId(id);

		Task updatedTask = new Task("Go home then shopping");
		updatedTask.setId(id);

		// WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(oldTask));
		Mockito.when(this.repo.save(updatedTask)).thenReturn(updatedTask);

		// THEN
		assertThat(this.service.updateTask(newTask, id)).isEqualTo(updatedTask);

	}

	@Test
	void testGet() {

		// GIVEN
		List<Task> tasks = new ArrayList<>();

		Integer id = 1;
		Task newTask = new Task("Go gym then go home");
		newTask.setId(id);
		tasks.add(newTask);

		// WHEN
		Mockito.when(this.repo.findAll()).thenReturn(tasks);

		// TEHN
		assertThat(this.service.getTask()).containsAll(tasks);
	}

	@Test
	void testDelete() {

		// GIVEN
		Integer id = 2;
		Task deletedTask = new Task("Go home then shopping");
		deletedTask.setId(id);

		// WHEN
		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		// THEN
		assertThat(this.service.deleteTask(id)).isEqualTo(true);
	}

}
