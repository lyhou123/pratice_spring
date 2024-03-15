package org.pratice.spring.service;
import org.pratice.spring.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
public interface TodoService {
        public List<Todo> getAllTodos();

        public Todo getTodoById(int id) ;

        public void addTodo(Todo todo) ;

        public void editTodo(Todo todo) ;

        public void deleteTodoById(int id);
        public List<Todo> searchTodos(String task, boolean isDone);
    }

