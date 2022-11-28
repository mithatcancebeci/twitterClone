package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;

public interface IUserService<UserReponse> extends IService<UserReponse> {
	Result findAllLikes(Long id);

	Result findAllTweets(Long id);

	Result findAllComments(Long id);
}
