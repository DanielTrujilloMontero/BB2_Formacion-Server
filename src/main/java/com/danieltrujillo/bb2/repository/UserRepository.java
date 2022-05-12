package com.danieltrujillo.bb2.repository;

import com.danieltrujillo.bb2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByName(String name);
}
