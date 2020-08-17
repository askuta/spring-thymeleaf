package com.epam.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.thymeleaf.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
