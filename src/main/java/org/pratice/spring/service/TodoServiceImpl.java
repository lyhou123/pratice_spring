package org.pratice.spring.service;
import lombok.RequiredArgsConstructor;
import org.pratice.spring.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final List<Todo> todoList;
    public List<Todo> getAllTodos() {
        return todoList;
    }
    public Todo getTodoById(int id) {
      return todoList.stream().filter(todo -> todo.getId() == id)
               .findFirst().orElse(null);
    }
    public void addTodo(Todo todo) {
         todo.setCreatedAt(LocalDate.now());
            todoList.add(todo);
    }
    public void editTodo(Todo todo) {
        todo.setCreatedAt(LocalDate.now());
        todoList.stream()
                .filter(t -> t.getId() == todo.getId())
                .findFirst()
                .ifPresentOrElse(
                        t -> {
                            int index = todoList.indexOf(t);
                            todoList.set(index, todo);
                        },
                        () -> {
                            throw new IllegalArgumentException("Todo with ID " + todo.getId() + " not found");
                        });
    }
    public void deleteTodoById(int id) {
        todoList.removeIf(todo -> todo.getId() == id);
    }
    public List<Todo> searchTodos(String task, boolean isDone) {
        return todoList.stream().filter(todo-> todo.getTask().contains(task) && todo.isDone() == isDone)
                .collect(Collectors.toList());
    }
}
