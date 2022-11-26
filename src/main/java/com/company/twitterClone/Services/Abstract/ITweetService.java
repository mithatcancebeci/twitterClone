package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Concrete.Tweet;
import com.company.twitterClone.Models.Dtos.CreateCommentDto;
import com.company.twitterClone.Models.Dtos.CreateLikeDto;
import com.company.twitterClone.Models.Dtos.CreateTweetDto;

public interface ITweetService<TweetDto> extends IService<TweetDto> {
	Result findAllComments();

	Result findAllLikes();

	Result findOneLike();
	
	Result likeTweet(CreateLikeDto likeInfo);
	
	Result unlikeTweet(CreateLikeDto unlikeInfo);
	
	Result createTweet(CreateTweetDto tweetInfo) throws Exception;

	Result createComment(CreateCommentDto commentInfo);
}
