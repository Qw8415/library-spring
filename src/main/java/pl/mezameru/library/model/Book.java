package pl.mezameru.library.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    @NotEmpty
    private String title;
    private String author;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
    private String publisher;
    private String publicationDate;
    private String isbn;
    @ColumnDefault("1")
    private boolean available;

    public Book() {
    }

    public Book(@NotEmpty String title, String author, Category category, String publisher, String publicationDate, String isbn) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", publisher='" + publisher + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + available +
                '}';
    }
}
