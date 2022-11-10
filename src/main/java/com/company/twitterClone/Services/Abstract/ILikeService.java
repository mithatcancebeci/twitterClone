package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;

public interface ILikeService{
	Result like(long id,long currentUserId);
	Result unLike(long id);
	Result getAllLikesByUser(long id);
	Result getAllLikesInTweet(long id);
}
