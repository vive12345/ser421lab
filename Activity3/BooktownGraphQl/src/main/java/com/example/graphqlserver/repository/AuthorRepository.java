package com.example.graphqlserver.repository;

import com.example.graphqlserver.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByLastNameIgnoreCase(String lastName);

    @Query("SELECT b.title FROM Book b WHERE LOWER(b.author.firstName) = LOWER(:firstName)")
    List<String> findBookTitlesByAuthorFirstName(@Param("firstName") String firstName);
}