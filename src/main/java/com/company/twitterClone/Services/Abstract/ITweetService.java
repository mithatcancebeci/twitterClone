package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Dtos.TweetCreateDto;
import com.company.twitterClone.Models.Dtos.TweetDto;

public interface ITweetService extends IService<TweetDto> {
	Result findAllComments();

	Result findOneComment();

	Result findAllLikes();

	Result findOneLike();

	Result createTweet(TweetCreateDto tweetCreateDto);
}
