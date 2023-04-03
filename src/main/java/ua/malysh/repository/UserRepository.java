package ua.malysh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.malysh.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
