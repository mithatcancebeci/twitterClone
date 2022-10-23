package com.company.twitterClone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.company.twitterClone.Models.Concrete.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findUserByEmail(String email);

	@Query("SELECT u FROM User u WHERE u.displayName = ?1")
	User findUserByDisplayName(String displayName);
}
