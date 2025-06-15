package com.prem.demo.repo;

import com.prem.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserDetails extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
