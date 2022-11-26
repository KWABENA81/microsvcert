package com.edu.bookms.service;

import com.edu.bookms.common.Issuer;
import com.edu.bookms.common.TransactionRequest;
import com.edu.bookms.common.TransactionResponse;
import com.edu.bookms.model.Book;
import com.edu.bookms.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository booksRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Collection<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        Optional<Book> optionalBook = booksRepository.findById(id);
        return (optionalBook.isPresent()) ? optionalBook.get() : optionalBook.orElseThrow();
    }

    public TransactionResponse saveBook(TransactionRequest request) {
        String response = "";
        Book book = request.getBook();
        Issuer issuer = request.getIssuer();
        issuer.setIsbn(book.getIsbn());

        Issuer issuerResponse = restTemplate
                .postForObject("http://ISSUER-MS/issuer/doBookIssuer/", issuer, Issuer.class);
        response = (issuerResponse.getIssuerConfirm().equalsIgnoreCase("SUCCESS"))
                ? "Issuer SUCCESFULL" : "FAILURE";
        booksRepository.save(book);
        return new TransactionResponse(book, issuerResponse.getIssuerId(), response);
    }

    public Book findByIsbn(String isbn) {
//        Optional<Book> optionalBook = booksRepository.findByIsbn(isbn);
//        return (optionalBook.isPresent()) ? optionalBook.get() : optionalBook.orElseThrow();
        return new Book();
    }

    public boolean delete(Integer id) {
        Optional<Book> optionalBook = booksRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            booksRepository.delete(book);
            return true;
        } else return false;
    }

    public Book save(Book book) {
        booksRepository.save(book);
        return book;
            }
}
