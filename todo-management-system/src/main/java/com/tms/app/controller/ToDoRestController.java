package com.tms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.app.dto.TodoDto;
import com.tms.app.service.IToDoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todos")
public class ToDoRestController {
	@Autowired
	private IToDoService todoService;

	@PostMapping
	public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {

		TodoDto savedTodo = todoService.addTodo(todoDto);

		return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<TodoDto> getTodo(@PathVariable("id") int todoId) {
		TodoDto todoDto = todoService.getTodo(todoId);
		return new ResponseEntity<>(todoDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<TodoDto>> getAllTodos() {
		List<TodoDto> todos = todoService.getAllTodos();
		return ResponseEntity.ok(todos);
	}

	@PutMapping("{id}")
	public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") int todoId) {
		TodoDto updatedTodo = todoService.updateTodo(todoDto, todoId);
		return ResponseEntity.ok(updatedTodo);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable("id") int todoId) {
		todoService.deleteTodo(todoId);
		return ResponseEntity.ok("Todo deleted");
	}

	@PutMapping("{id}/complete")
	public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") int todoId) {
		TodoDto updatedTodo = todoService.completeTodo(todoId);
		return ResponseEntity.ok(updatedTodo);
	}

	@PutMapping("{id}/in-complete")
	public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") int todoId) {
		TodoDto updatedTodo = todoService.inCompleteTodo(todoId);
		return ResponseEntity.ok(updatedTodo);
	}

}
