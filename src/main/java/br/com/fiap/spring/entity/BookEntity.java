package br.com.fiap.spring.entity;

import br.com.fiap.spring.model.dto.CreateUpdateBookDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbBook")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String isbn;

    @Column
    private Date publicationDate;

    @Column
    private Double price;

    public BookEntity() {
    }

    public BookEntity(CreateUpdateBookDTO updateBook) {
        this.title = updateBook.getTitle();
        this.description = updateBook.getDescription();
        this.isbn = updateBook.getIsbn();
        this.publicationDate = updateBook.getPublication();
        this.price = updateBook.getPrice();
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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
