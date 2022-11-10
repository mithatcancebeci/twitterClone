package com.company.twitterClone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Concrete.Like;
import com.company.twitterClone.Models.Concrete.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
