package com.springpractise.SpringMVC.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDto {
    private int id;
    @NotEmpty(message = "Club title should not be empty")
    private String title;
    @NotEmpty(message = "Club photoURL should not be empty")
    private String photoUrl;
    @NotEmpty(message = "Club content should not be empty")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    private List<EventDto> events;
}
