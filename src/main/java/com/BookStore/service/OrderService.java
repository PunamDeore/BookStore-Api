package com.BookStore.service;

import com.BookStore.dto.OrderDTO;
import com.BookStore.entity.Book;
import com.BookStore.entity.Order;
import com.BookStore.entity.User;
import com.BookStore.exception.ResourceNotFoundException;
import com.BookStore.repository.BookRepository;
import com.BookStore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    public Order placeOrder(OrderDTO orderDTO) {
        // Fetching the user and books from the repositories
        User customer = orderDTO.getCustomer();
        List<Book> books = orderDTO.getBookIds().stream()
                .map(bookId -> bookRepository.findById(bookId)
                        .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId)))
                .collect(Collectors.toList());

        // Calculating total price and quantity
        double totalPrice = books.stream().mapToDouble(Book::getPrice).sum();
        int quantity = books.size();

        // Creating and saving the order
        Order order = new Order();
        order.setCustomer(customer);
        order.setBooks(books);
        order.setQuantity(quantity);
        order.setTotalPrice(totalPrice);
        order.setOrderDate(LocalDate.now());

        return orderRepository.save(order);
    }
    public Page<Order> getOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    

    public List<Order> getOrderHistory(User customer) {
        return orderRepository.findByCustomer(customer);
    }
    
}
