package org.pratice.spring.controller;

import lombok.RequiredArgsConstructor;
import org.pratice.spring.model.Todo;
import org.pratice.spring.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
 private final TodoService todoService;
    @GetMapping("/todo")
    public String getAllTodos(Model model) {
      model.addAttribute("todos", todoService.getAllTodos());
        return "index";
    }

    @GetMapping("/todo/{id}")
    public String getTodoById(@PathVariable int id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "view";
    }
    @GetMapping("/todo/new")
    public String showNewTodoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "form";
    }
//
    @PostMapping("/todo/new")
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.addTodo(todo);
        return "redirect:/todo";
    }
    @GetMapping("/todo/edit/{id}")
    public String showEditTodoForm(@PathVariable int id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "edit";
    }

    @PostMapping("/todo/edit/{id}")
    public String editTodo(@PathVariable int id, @ModelAttribute Todo todo) {
        todo.setId(id);
        todoService.editTodo(todo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        todoService.deleteTodoById(id);
        return "redirect:/todo";
    }
    @GetMapping("/todo/search")
    public String searchTodos(@RequestParam(name = "task", required = false) String task,
                              @RequestParam(name = "isDone", required = false) Boolean isDone,
                              Model model) {
        List<Todo> todos;
        if (task != null && !task.isEmpty()) {
            if (isDone != null) {
                todos = todoService.searchTodos(task, isDone);
            } else {
                todos = todoService.searchTodos(task,false);
            }
        } else {
            todos = todoService.getAllTodos();
        }
        model.addAttribute("todos", todos);
        return "index";
    }
}

