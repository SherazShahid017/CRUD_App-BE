package com.example.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.todo.domain.Task;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
class TaskAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void increaseCoverage() {
		EqualsVerifier.forClass(Task.class).usingGetClass().verify();
	}
}
