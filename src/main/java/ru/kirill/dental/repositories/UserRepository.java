package ru.kirill.dental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirill.dental.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
