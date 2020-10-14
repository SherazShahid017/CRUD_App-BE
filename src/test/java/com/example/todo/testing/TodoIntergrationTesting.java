package com.example.todo.testing;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.todo.domain.Task;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:todo-schema.sql",
		"classpath:todo-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class TodoIntergrationTesting {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void createTest() throws Exception {
		Task newTask = new Task("Go home then go gym");
		String body = this.mapper.writeValueAsString(newTask);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(body);

		ResultMatcher checkStatus = status().isCreated();

		Task savedTask = new Task("Go home then go gym");
		savedTask.setId(2);

		String ResultBody = this.mapper.writeValueAsString(savedTask);

		ResultMatcher checkBody = content().json(ResultBody);

		this.mockMVC.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void deleteTest() throws Exception {
		RequestBuilder request = delete("/delete/1");

		ResultMatcher checkStatus = status().is(200);

		this.mockMVC.perform(request).andExpect(checkStatus);
	}

	@Test
	void updateTest() throws Exception {
		Task newTask = new Task("Go gym then go home");
		String body = this.mapper.writeValueAsString(newTask);
		RequestBuilder req = put("/update?id=1").contentType(MediaType.APPLICATION_JSON).content(body);

		ResultMatcher checkStatus = status().is(202);

		Task savedTask = new Task("Go gym then go home");
		savedTask.setId(2);

		String ResultBody = this.mapper.writeValueAsString(savedTask);

		ResultMatcher checkBody = content().json(ResultBody);

		this.mockMVC.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void readTest() throws Exception {
		Task task = new Task("Go gym then go home");
		task.setId(1);
		List<Task> tasks = new ArrayList<>();
		tasks.add(task);
		String ResponseBody = this.mapper.writeValueAsString(tasks);

		this.mockMVC.perform(get("/get")).andExpect(status().isOk()).andExpect(content().json(ResponseBody));
	}
}
