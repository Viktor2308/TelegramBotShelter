package com.example.telegrambotshelter.db.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"breed", "catName", "yearOfBirthday", "description"})
@ToString(of = {"id", "breed", "catName", "yearOfBirthday", "description"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cat")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;
    @Column(name = "breed")
    private String breed;
    @Column(name = "cat_name")
    private String catName;
    @Column(name = "year_of_birthday")
    private int yearOfBirthday;
    @Column(name = "description")
    private String description;

    public Cat(String breed, String catName, int yearOfBirthday, String description) {
        this.breed = breed;
        this.catName = catName;
        this.yearOfBirthday = yearOfBirthday;
        this.description = description;
    }
}



