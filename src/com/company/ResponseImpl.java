package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class ResponseImpl {
    private int total, totalPages;
    private List<Info> results;
}
