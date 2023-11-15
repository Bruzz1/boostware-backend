package com.boostware.taskservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "TASK_TBL")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @SequenceGenerator(name = "task_id_sequence",
            sequenceName = "task_id_sequence")

    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "task_id_sequence")
    private long id;

    private String description;

    private boolean status;

    private LocalDate targetDate;

    private String username;
}
