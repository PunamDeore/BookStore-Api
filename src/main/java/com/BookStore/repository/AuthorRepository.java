package com.BookStore.repository;

import com.BookStore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // You can define custom query methods here if needed

    // Example: Find an author by name
    Author findByName(String name);
}
