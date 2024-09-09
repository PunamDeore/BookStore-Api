package com.BookStore.dto;

public class AuthorDTO {
    private String name;


    public AuthorDTO() {
    }

 
    public AuthorDTO(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
