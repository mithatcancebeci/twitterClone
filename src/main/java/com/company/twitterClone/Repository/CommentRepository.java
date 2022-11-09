package com.company.twitterClone.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.company.twitterClone.Models.Concrete.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
