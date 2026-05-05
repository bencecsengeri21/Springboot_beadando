package com.example.beadando.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;                // Alap típus 1
    private String name;            // Alap típus 2
    private int age;                // Alap típus 3
    private boolean active;         // Alap típus 4

    private List<String> emailAddresses = new ArrayList<>(); // Collection típus

    // Több-Több kapcsolat előkészítése
    private List<Long> courseIds = new ArrayList<>();
}