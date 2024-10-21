package com.celyngcoding.jpa.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Author extends BaseEntity {



    private String firstName;
    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private int age;


    @ManyToMany(mappedBy = "authors")
    private List<Course> course;

}
