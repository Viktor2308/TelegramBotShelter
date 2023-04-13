package com.example.telegrambotshelter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dog")
@Data
@NoArgsConstructor
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "breed")
    private String breed;
    @Column(name = "name")
    private String name;
    @Column(name = "year_of_birthday")
    private int yearOfBirthday;
    @Column(name = "description")
    private String description;
}
