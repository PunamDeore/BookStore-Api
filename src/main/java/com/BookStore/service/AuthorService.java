package com.BookStore.service;

import com.BookStore.dto.AuthorDTO;
import com.BookStore.entity.Author;
import com.BookStore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author addAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        return authorRepository.save(author);
    }
}
