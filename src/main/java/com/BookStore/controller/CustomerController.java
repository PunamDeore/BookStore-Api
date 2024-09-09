package com.BookStore.controller;

import com.BookStore.entity.Book;
import com.BookStore.entity.Order;
import com.BookStore.dto.OrderDTO;
import com.BookStore.entity.User;
import com.BookStore.service.BookService;
import com.BookStore.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;
    @GetMapping("/books/search")
    public List<Book> searchBooks(@RequestParam String query) {
        return bookService.searchBooks(query);
    }
    @GetMapping("/books")
    @Operation(summary = "Browse available books", description = "Retrieves a list of available books.")
    @ApiResponse(responseCode = "200", description = "List of books retrieved successfully.")
    public List<Book> browseBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/orders")
    @Operation(summary = "Place a new order", description = "Places a new order based on the provided order details.")
    @ApiResponse(responseCode = "201", description = "Order placed successfully.")
    public Order placeOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.placeOrder(orderDTO);
    }

    @GetMapping("/orders/history")
    @Operation(summary = "Get order history", description = "Retrieves the order history for the authenticated user.")
    @ApiResponse(responseCode = "200", description = "Order history retrieved successfully.")
    public List<Order> getOrderHistory(@AuthenticationPrincipal User user) {
        return orderService.getOrderHistory(user);
    }
}
