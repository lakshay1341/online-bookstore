package com.bookstore.service;

import com.bookstore.entity.Book;
import com.bookstore.repo.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        logger.info("Fetching all books");
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        logger.info("Fetching book with ID: {}", id);
        return bookRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        if (bookRepository.existsByIsbn(book.getIsbn())) {
            logger.warn("Book with ISBN {} already exists", book.getIsbn());
            throw new RuntimeException("Book with ISBN " + book.getIsbn() + " already exists");
        }
        logger.info("Creating book with ISBN: {}", book.getIsbn());
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPrice(bookDetails.getPrice());
        book.setIsbn(bookDetails.getIsbn());
        book.setGenre(bookDetails.getGenre());
        book.setStockQuantity(bookDetails.getStockQuantity());
        logger.info("Updating book with ID: {}", id);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            logger.warn("Book with ID {} not found for deletion", id);
            throw new RuntimeException("Book not found with ID: " + id);
        }
        logger.info("Deleting book with ID: {}", id);
        bookRepository.deleteById(id);
    }

    public List<Book> findByGenre(String genre) {
        logger.info("Fetching books with genre: {}", genre);
        return bookRepository.findByGenre(genre);
    }
}