package com.boostware.taskservice.dto;


import java.time.LocalDate;

public record TaskDto(Long id, String description, String status,LocalDate targetDate, String username) {
}
