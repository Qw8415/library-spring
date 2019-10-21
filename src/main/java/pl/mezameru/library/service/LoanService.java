package pl.mezameru.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mezameru.library.model.Book;
import pl.mezameru.library.model.Loan;
import pl.mezameru.library.model.User;
import pl.mezameru.library.repository.LoanRepository;

import java.sql.Date;
import java.util.Calendar;

@Service
public class LoanService {
    private final static int LOAN_DAYS = 14;

    private LoanRepository loanRepository;

    public LoanService() {   }

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan loanBook(Book book, User user) {
        Date currentDate = new Date(new java.util.Date().getTime());
        Date returnDeadLine = getReturnDeadLine(currentDate);
        Loan loan = new Loan(currentDate, returnDeadLine, user, book);
        book.setAvailable(false);
        loanRepository.save(loan);
        return loan;
    }

    private Date getReturnDeadLine(Date currentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, LOAN_DAYS);
        return new Date(calendar.getTimeInMillis());
    }

    public Loan findNotReturnedBook(Book book) {
        return loanRepository.findNotReturnedBook(book);
    }
}
