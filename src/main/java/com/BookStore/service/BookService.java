package com.BookStore.service;

import com.BookStore.dto.BookDTO;
import com.BookStore.entity.Book;
import com.BookStore.exception.ResourceNotFoundException;
import com.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(BookDTO bookDTO) {
        // Convert BookDTO to Book entity
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setPrice(bookDTO.getPrice());
        book.setStockQuantity(bookDTO.getStockQuantity());

        return bookRepository.save(book);
    }
    public List<Book> searchBooks(String query) {
        return bookRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrIsbnContainingIgnoreCase(query, query, query);
    }
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Page<Book> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
    public Book updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        book.setTitle(bookDTO.getTitle());
        book.setPrice(bookDTO.getPrice());
        book.setStockQuantity(bookDTO.getStockQuantity());
        return bookRepository.save(book);
    }
    public Book updateStock(Long id, int stock) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        book.setStock(stock);  // Assuming Book has a setStock method
        return bookRepository.save(book);
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
