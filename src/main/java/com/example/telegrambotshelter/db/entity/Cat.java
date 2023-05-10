package com.example.telegrambotshelter.db.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"breed", "catName", "yearOfBirthday", "description"})
@ToString(of = {"breed", "catName", "yearOfBirthday", "description"})
@NoArgsConstructor
@Table(name = "cat")
public class Cat {
    @Id
    private long id;
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



