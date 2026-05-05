package com.example.beadando.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Long id;
    private String name;            // Átírtam 'name'-re, hogy egyezzen a teszteddel
    private Integer credit;         // int helyett Integer (így nem dob 400-as hibát, ha gond van)
    private Boolean mandatory;      // boolean helyett Boolean
    private String description;     // Hozzáadtam, mert a tesztedben szerepel

    private List<String> requirements = new ArrayList<>();
    private List<Long> studentIds = new ArrayList<>();
    private Long departmentId;
}