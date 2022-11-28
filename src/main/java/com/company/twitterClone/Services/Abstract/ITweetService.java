package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Request.CreateCommentRequest;
import com.company.twitterClone.Models.Request.CreateLikeRequest;
import com.company.twitterClone.Models.Request.CreateTweetRequest;

public interface ITweetService<TweetResponse> extends IService<TweetResponse> {
	Result findAllComments();

	Result findAllLikes();

	Result findOneLike();

	Result likeTweet(CreateLikeRequest likeInfo);

	Result unlikeTweet(CreateLikeRequest unlikeInfo);

	Result createTweet(CreateTweetRequest tweetInfo) throws Exception;

	Result createComment(CreateCommentRequest commentInfo);
}
