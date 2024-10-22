package com.celyngcoding.jpa.repositories;

import com.celyngcoding.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    // Using NamedQuery
    @Transactional
    List<Author> findByNamedQuery(@Param("id") Integer id);
    // Using NamedQuery

    @Modifying
    @Transactional
    void updateByNamedQuery( @Param("age") Integer age,@Param("id") Integer id);

    // Update Author a set a.age = 22 where a.id =  1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);
    // SELECT * FROM author WHERE first_name = 'CELY'
    List<Author> findAllByFirstName(String fn);
    // SELECT * FROM author WHERE first_name = 'ce'
    List<Author> findAllByFirstNameIgnoreCase(String fn);
    // SELECT * FROM author WHERE first_name like '%cel%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);
    // SELECT * FROM author WHERE first_name like 'cel%'
    List<Author> findAllByFirstNameStartingWithIgnoreCase(String fn);
    // SELECT * FROM author WHERE first_name like '%cel'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);
    // SELECT * FROM author WHERE first_name in ('manuel','cely','coding')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

}
