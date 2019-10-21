package pl.mezameru.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.mezameru.library.model.Book;
import pl.mezameru.library.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query("SELECT l FROM Loan l WHERE l.book = ?1 AND l.returnDate = null")
    public Loan findNotReturnedBook(Book book);
}
