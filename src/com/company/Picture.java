package com.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Picture {
    private int width, height;
    private String color;
}
