package ua.malysh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.malysh.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}