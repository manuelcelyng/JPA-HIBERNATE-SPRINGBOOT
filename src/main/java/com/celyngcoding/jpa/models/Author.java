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

@NamedQueries(
        {
                @NamedQuery(
                        name = "Author.findByNamedQuery",
                        query = "select a from Author a where a.age >= :age"
                ),
                @NamedQuery(
                        name = "Author.updateByNamedQuery",
                        query = "update Author a  set a.age=:age where a.id = :id"
                )
        }
)
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
