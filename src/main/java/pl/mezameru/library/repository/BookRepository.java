package pl.mezameru.library.repository;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.mezameru.library.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.title LIKE CONCAT('%',?1,'%') AND b.author LIKE CONCAT('%',?2,'%') AND b.category LIKE CONCAT('%',?3,'%')")
    public List<Book> findAllByFormCriteria(String title, String author, String category);
}
