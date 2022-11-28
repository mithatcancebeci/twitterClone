package com.company.twitterClone.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.twitterClone.Models.Concrete.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
