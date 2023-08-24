package org.library.model.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    private UUID id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "genre")
    private String genre;
    @Column(name = "description")
    private String description;
    @Column(name = "isbn")
    private long isbn;
    @Column(name = "image_url")
    private String imageURL;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "published")
    private Date published;
    @Column(name = "price")
    private double price;

    @ManyToMany
    @JoinTable(name = "orders_books",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"))
    private List<Order> orders;
    @ManyToMany
    @JoinTable(name = "users_books",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> user;

}
