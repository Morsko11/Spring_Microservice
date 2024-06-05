package com.example.microservice.dtoUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class User_dto {
    private String name;
    private int age;
    private double hight;
}
