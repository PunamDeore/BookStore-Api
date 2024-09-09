package com.BookStore.controller;

import com.BookStore.entity.Book;
import com.BookStore.entity.Order;
import com.BookStore.service.BookService;
import com.BookStore.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/books")
    @Operation(summary = "View all books", description = "Retrieves a list of all books in the inventory.")
    @ApiResponse(responseCode = "200", description = "List of books retrieved successfully.")
    public List<Book> viewBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/books/search")
    public List<Book> searchBooks(@RequestParam String query) {
        return bookService.searchBooks(query);
    }
    @PutMapping("/books/{id}/stock")
    @Operation(summary = "Update book stock", description = "Updates the stock of a specific book.")
    @ApiResponse(responseCode = "200", description = "Stock updated successfully.")
    public Book updateStock(
        @Parameter(description = "ID of the book to update") @PathVariable Long id, 
        @RequestBody int stock
    ) {
        return bookService.updateStock(id, stock);
    }

    @GetMapping("/orders")
    @Operation(summary = "Get all orders", description = "Retrieves a list of all orders.")
    @ApiResponse(responseCode = "200", description = "List of orders retrieved successfully.")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
