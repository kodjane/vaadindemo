package com.kadconsulting.vaadindemo.ui;

import com.kadconsulting.vaadindemo.backend.Book;
import com.kadconsulting.vaadindemo.backend.BookService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

import javax.annotation.security.RolesAllowed;

@Route("admin")
@RolesAllowed("ADMIN")
public class AdminView extends VerticalLayout {
    public AdminView(BookService bookService){
        GridCrud<Book> crud = new GridCrud<>(Book.class, bookService);
        crud.getGrid().setColumns("title","published","rating");
        crud.getCrudFormFactory().setVisibleProperties("title","published","rating");
        add(
                new H1("Admin view"),
                crud
        );
    }
}
