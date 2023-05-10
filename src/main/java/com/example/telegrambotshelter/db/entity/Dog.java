package com.example.telegrambotshelter.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"breed", "dogName", "yearOfBirthday", "description"})
@ToString(of = {"id", "breed", "dogName", "yearOfBirthday", "description"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;
    @Column(name = "breed")
    private String breed;
    @Column(name = "dog_name")
    private String dogName;
    @Column(name = "year_of_birthday")
    private int yearOfBirthday;
    @Column(name = "description")
    private String description;

    public Dog(String breed, String dogName, int yearOfBirthday, String description) {
        this.breed = breed;
        this.dogName = dogName;
        this.yearOfBirthday = yearOfBirthday;
        this.description = description;
    }
}
