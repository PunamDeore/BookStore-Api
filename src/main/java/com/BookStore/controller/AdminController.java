package com.BookStore.controller;

import com.BookStore.dto.BookDTO;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/books")
    @Operation(summary = "Add a new book", description = "Adds a new book to the inventory.")
    @ApiResponse(responseCode = "200", description = "Book added successfully.")
    public Book addBook(@RequestBody BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }
    @GetMapping("/books/search")
    public List<Book> searchBooks(@RequestParam String query) {
        return bookService.searchBooks(query);
    }
    @PutMapping("/books/{id}")
    @Operation(summary = "Update an existing book", description = "Updates the details of an existing book.")
    @ApiResponse(responseCode = "200", description = "Book updated successfully.")
    public Book updateBook(
        @Parameter(description = "ID of the book to be updated") @PathVariable Long id, 
        @RequestBody BookDTO bookDTO
    ) {
        return bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/books/{id}")
    @Operation(summary = "Delete a book", description = "Deletes a book from the inventory.")
    @ApiResponse(responseCode = "204", description = "Book deleted successfully.")
    public void deleteBook(@Parameter(description = "ID of the book to be deleted") @PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/orders")
    @Operation(summary = "Get all orders", description = "Retrieves a list of all orders.")
    @ApiResponse(responseCode = "200", description = "List of orders retrieved successfully.")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
