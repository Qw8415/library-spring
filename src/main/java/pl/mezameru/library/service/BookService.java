package pl.mezameru.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mezameru.library.model.Book;
import pl.mezameru.library.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findBookByForm(Book book) {
        return bookRepository.findAllByFormCriteria(book.getTitle(), book.getAuthor(), book.getCategory().getName());
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
