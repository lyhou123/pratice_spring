package org.pratice.spring.datasource;
import org.pratice.spring.model.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Configuration
public class Datasource {
    @Bean
    public List<Todo> personList()
    {
        return new ArrayList<>(){{
            add(new Todo(1, "Task 1", "Description 1", false, LocalDate.now()));
            add(new Todo(2, "Task 2", "Description 2", false,  LocalDate.now()));
            add(new Todo(3, "Task 3", "Description 3", false,  LocalDate.now()));
        }};
    }
}
