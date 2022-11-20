package com.kadconsulting.vaadindemo.ui;

import com.kadconsulting.vaadindemo.backend.Book;
import com.kadconsulting.vaadindemo.backend.BookService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

@Route("NewBook")
@RolesAllowed("ADMIN")
public class NewBookView extends VerticalLayout {

    TextField title = new TextField("Title");
    DatePicker published = new DatePicker("Published");
    IntegerField rating = new IntegerField("Rating");

    public NewBookView(BookService bookService) {
        Binder<Book> binder = new Binder<>(Book.class);
        binder.bindInstanceFields(this);

        add(
                new H1("New Book"),
                new FormLayout(title, published, rating),
                new Button("Save", buttonClickEvent -> {
                    Book book = new Book();
                    binder.writeBeanIfValid(book);
                    bookService.add(book);
                    Notification.show("The book has been saved");
                    binder.readBean(new Book()); //This allow to clean up the form after a save
                })
        );

    }
}
