package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Concrete.Tweet;

public interface ITweetService<TweetDto> extends IService<TweetDto> {
	Result findAllComments();

	Result findOneComment();

	Result findAllLikes();

	Result findOneLike();

	Result createTweet(Tweet tweet);
}
