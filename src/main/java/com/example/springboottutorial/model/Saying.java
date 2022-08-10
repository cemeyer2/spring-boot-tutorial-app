package com.example.springboottutorial.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Saying {

    private long id;
    private String content;
}
