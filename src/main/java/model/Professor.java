package com.example.beadando.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor {
    private Long id;
    private String firstName;
    private String lastName;
    private boolean tenured;

    private List<String> degrees = new ArrayList<>(); // Collection

    // Több az egyhez kapcsolat: A professzor egy tanszékhez tartozik
    private Long departmentId;
}