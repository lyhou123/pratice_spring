package org.pratice.spring.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int id;
    private String task;
    private String description;
    private boolean isDone;
    private LocalDate createdAt;
}
