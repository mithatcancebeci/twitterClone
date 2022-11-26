package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Concrete.Tweet;
import com.company.twitterClone.Models.Dtos.CreateTweetDto;

public interface ITweetService<TweetDto> extends IService<TweetDto> {
	Result findAllComments();

	Result findOneComment();

	Result findAllLikes();

	Result findOneLike();

	Result createTweet(CreateTweetDto tweetInfo) throws Exception;

	Result createComment(Tweet comment, long userId, long tweetId);
}
