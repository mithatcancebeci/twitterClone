package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;

public interface ILikeService {
	Result likeTweet(long tweetId, long userId);

//	Result likeComment(long commentId, long userId);

	Result unLikeTweet(long tweetId, long userId);

	Result getAllLikesByUser(long id);

	Result getAllLikesInTweet(long id);
}
