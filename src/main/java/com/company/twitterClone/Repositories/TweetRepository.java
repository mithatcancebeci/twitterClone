package com.company.twitterClone.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.twitterClone.Models.Concrete.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
