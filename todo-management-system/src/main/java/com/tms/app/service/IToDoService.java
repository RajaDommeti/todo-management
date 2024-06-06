package com.tms.app.service;

import java.util.List;

import com.tms.app.dto.TodoDto;

public interface IToDoService {
	 TodoDto addTodo(TodoDto todoDto);

	 TodoDto getTodo(int id);

	 List<TodoDto> getAllTodos();

	 TodoDto updateTodo(TodoDto todoDto, int id);

	 void deleteTodo(int id);

	 TodoDto completeTodo(int id);

	 TodoDto inCompleteTodo(int id);
}
