package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;

public interface ILikeService {
	Result likeTweet(long tweetId, long userId);

//	Result likeComment(long commentId, long userId);

	Result unLike(long id);

	Result getAllLikesByUser(long id);

	Result getAllLikesInTweet(long id);
}
