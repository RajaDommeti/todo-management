package com.tms.app.mapper;

import com.tms.app.dto.TodoDto;
import com.tms.app.entity.Todo;

public class TodoMapper {
	public static TodoDto mapToTodoDto(Todo todo) {
		return new TodoDto(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted());
	}

	public static Todo mapToTodo(TodoDto todoDto) {
		Todo todo = new Todo();
		todo.setId(todoDto.getId());
		todo.setTitle(todoDto.getTitle());
		todo.setDescription(todoDto.getDescription());
		todo.setCompleted(todoDto.isCompleted());
		return todo;
	}
}
