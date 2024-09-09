package com.BookStore.dto;

import com.BookStore.entity.User;
import java.util.List;

public class OrderDTO {

    private User customer;
    private List<Long> bookIds;


    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public List<Long> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Long> bookIds) {
        this.bookIds = bookIds;
    }
}
