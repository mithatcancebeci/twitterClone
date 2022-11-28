package com.company.twitterClone.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.twitterClone.Models.Concrete.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

	Optional<User> findByUsername(String username);
}
