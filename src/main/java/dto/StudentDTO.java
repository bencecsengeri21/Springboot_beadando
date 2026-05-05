package com.example.beadando.dto;

import lombok.Data;
import java.util.List;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private int age;
    private boolean active;
    private List<String> emailAddresses;
}