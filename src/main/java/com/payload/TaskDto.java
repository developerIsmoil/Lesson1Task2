package com.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    @NotNull(message = "name bo'sh bo'lmasligi kerak")
    private String name;
    @NotNull(message = "departmentId bo'sh bo'lmasligi kerak")
    private Long departmentId;
}
