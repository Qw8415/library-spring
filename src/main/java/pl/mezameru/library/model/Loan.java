package pl.mezameru.library.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long id;
    @Column(nullable = false)
    private Date loanDate;
    private Date returnDate;
    private Date returnDeadLine;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Loan() {
    }

    public Loan(Date loanDate, Date returnDeadLine, User user, Book book) {
        this.loanDate = loanDate;
        this.returnDeadLine = returnDeadLine;
        this.user = user;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getReturnDeadLine() {
        return returnDeadLine;
    }

    public void setReturnDeadLine(Date returnDeadLine) {
        this.returnDeadLine = returnDeadLine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
