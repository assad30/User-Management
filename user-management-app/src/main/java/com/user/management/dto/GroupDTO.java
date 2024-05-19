package com.user.management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;



@Data
public class GroupDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;
}
