package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;

public interface IUserService<UserDto> extends IService<UserDto> {
	Result findAllLikes(long id);

	Result findAllTweets(long id);

	Result findAllComments(long id);
}
