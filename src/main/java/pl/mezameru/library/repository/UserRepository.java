package pl.mezameru.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mezameru.library.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
