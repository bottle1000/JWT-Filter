package org.example.jwtfilter.user.repository;

import java.util.Optional;
import org.example.jwtfilter.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
