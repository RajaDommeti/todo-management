package com.tms.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.app.dto.TodoDto;
import com.tms.app.entity.Todo;
import com.tms.app.exception.ResourceNotFoundException;
import com.tms.app.mapper.TodoMapper;
import com.tms.app.repo.IToDoRepo;

@Service
public class ToDoServiceImpl implements IToDoService {
	@Autowired
	private IToDoRepo todoRepo;

	@Override
	public TodoDto addTodo(TodoDto todoDto) {

		Todo todo = TodoMapper.mapToTodo(todoDto);
		Todo savedTodo = todoRepo.save(todo);
		return TodoMapper.mapToTodoDto(savedTodo);
	}

	@Override
	public TodoDto getTodo(int id) {
		Todo todo = todoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + id));
		return TodoMapper.mapToTodoDto(todo);
	}

	@Override
	public List<TodoDto> getAllTodos() {
		

		List<Todo> todos = todoRepo.findAll();
		return todos.stream().map(TodoMapper::mapToTodoDto).collect(Collectors.toList());
	}

	@Override
	public TodoDto updateTodo(TodoDto todoDto, int id) {
		Todo todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + id));

		todo.setTitle(todoDto.getTitle());
		todo.setDescription(todoDto.getDescription());
		todo.setCompleted(todoDto.isCompleted());
		Todo updatedTodo = todoRepo.save(todo);
		return TodoMapper.mapToTodoDto(updatedTodo);
	}

	@Override

	public void deleteTodo(int id) {
		Todo todo = todoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

		todoRepo.deleteById(id);
	}

	@Override
	public TodoDto completeTodo(int id) {
		Todo todo = todoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

		todo.setCompleted(Boolean.TRUE);
		Todo updatedTodo = todoRepo.save(todo);
		return TodoMapper.mapToTodoDto(updatedTodo);
	}

	@Override
	public TodoDto inCompleteTodo(int id) {
		Todo todo = todoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

		todo.setCompleted(Boolean.FALSE);
		Todo updatedTodo = todoRepo.save(todo);
		return TodoMapper.mapToTodoDto(updatedTodo);
	}

}