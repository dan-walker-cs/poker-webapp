package com.dan_walker_cs.have_them_webapp.repository;

import com.dan_walker_cs.have_them_webapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// This class provides the use of JpaRepository class functions and specifies the relationship.
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
