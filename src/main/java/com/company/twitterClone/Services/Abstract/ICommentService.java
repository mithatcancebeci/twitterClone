package com.company.twitterClone.Services.Abstract;

import java.util.List;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Concrete.Tweet;

public interface ICommentService<TweetDto> extends IService<TweetDto> {
	Result createComment(Tweet tweet) throws Exception;

	List<TweetDto> findAllCommentsByUser(long id) throws Exception;

	List<TweetDto> findAllCommentsByTweet(long id) throws Exception;

}
