package com.example.graphqlserver;

import com.example.graphqlserver.model.Author;
import com.example.graphqlserver.model.Book;
import com.example.graphqlserver.repository.AuthorRepository;
import com.example.graphqlserver.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            // Create authors
            Author author1 = new Author("Robert", "Frost");
            Author author2 = new Author("Martin", "Fowler");
            Author author3 = new Author("Kevin", "Gary");

            // Save authors first
            authorRepository.save(author1);
            authorRepository.save(author2);
            authorRepository.save(author3);

            // Create books
            Book book1 = new Book("123456789", "The Road Not Taken", author1);
            Book book2 = new Book("987654321", "To Kill a Mockingbird", author2);
            Book book3 = new Book("456789123", "The Great Gatsby", author3);

            // Save books
            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);
        };
    }
}