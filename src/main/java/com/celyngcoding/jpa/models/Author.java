package com.celyngcoding.jpa.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue/*( // HAVE diferent types, default is AUTO
            //strategy = GenerationType.SEQUENCE,
            //generator = "author_sequence"
            strategy = GenerationType.TABLE,
            generator = "author_id_gen"
    )*/
    /*
    @SequenceGenerator( // the sequence taht we want to use
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    ) */
    /*
    @TableGenerator(
            name = "author_id_gen",
            table = "id_generator",
            pkColumnName = "id_name",
            valueColumnName = "id_value",
            allocationSize = 1
    )*/
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
}
