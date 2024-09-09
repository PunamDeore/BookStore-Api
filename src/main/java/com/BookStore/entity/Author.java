package com.BookStore.entity;

import java.util.ArrayList;
import java.util.List;


@jakarta.persistence.Entity
public class Author {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;

    @jakarta.persistence.OneToMany(mappedBy = "author", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author [id=" + id + ", name=" + name + "]";
    }
}
