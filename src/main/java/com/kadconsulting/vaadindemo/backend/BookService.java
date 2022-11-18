package com.kadconsulting.vaadindemo.backend;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BookService implements CrudListener<Book> {
    private final BooksRepository booksRepository;

    @Override
    public Collection<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Book add(Book book) {
        return booksRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return booksRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        booksRepository.delete(book);
    }
}
