package br.com.fiap.spring.model.dto;

import br.com.fiap.spring.entity.BookEntity;

import java.util.Date;

public class BookDTO {
    private long id;
    private String title;
    private String description;
    private String isbn;

    private Date publication;
    private double price;


    public BookDTO(String title, String description, String isbn, Date publication, double price) {
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.publication = publication;
        this.price = price;
    }

    public BookDTO(BookEntity book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.isbn = book.getIsbn();
        this.publication = book.getPublicationDate();
        this.price = book.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
