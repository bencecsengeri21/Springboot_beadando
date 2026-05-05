package com.example.beadando.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Long id;
    private String name;
    private String location; // <--- Ezt add hozzá (a buildingCode és floor helyett vagy mellé)

    private List<String> roomNumbers = new ArrayList<>();
    private List<Long> professorIds = new ArrayList<>();
}