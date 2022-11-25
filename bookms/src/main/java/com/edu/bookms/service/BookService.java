package com.edu.bookms.service;

import com.edu.bookms.model.Book;
import com.edu.bookms.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository booksRepository;

    @Override
    public Collection<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        Optional<Book> optionalBook = booksRepository.findById(id);
        return (optionalBook.isPresent()) ? optionalBook.get() : optionalBook.orElseThrow();
    }

    public Book save(Book book) {
        return booksRepository.save(book);
    }

    public Book findByIsbn(String isbn) {
//        Optional<Book> optionalBook = booksRepository.findByIsbn(isbn);
//        return (optionalBook.isPresent()) ? optionalBook.get() : optionalBook.orElseThrow();
        return new Book();
    }

    public boolean delete(Integer id) {
        return false;//booksRepository.delete(id);
    }
}
