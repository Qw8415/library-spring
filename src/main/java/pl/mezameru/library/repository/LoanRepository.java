package pl.mezameru.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.mezameru.library.model.Book;
import pl.mezameru.library.model.Loan;
import pl.mezameru.library.model.User;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query("SELECT l FROM Loan l WHERE l.book = ?1 AND l.returnDate = null")
    public Loan findNotReturnedBook(Book book);

    @Query("SELECT l FROM Loan l WHERE l.user.username=?1")
    public List<Loan> findAllByUsername(String username);
}
