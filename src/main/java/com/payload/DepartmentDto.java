package com.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    @NotNull(message = "name bo'sh bo'lmasligi kerak")
    private String name;
    @NotNull(message = "categoryId bo'sh bo'lmasligi kerak")
    private Long categoryId;
}
