package com.company.twitterClone.Services.Concrete;

import java.util.List;

import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Services.Abstract.IUserService;

public class UserManager<UserDto> implements IUserService<UserDto> {

	@Override
	public DataResult<UserDto> findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<UserDto>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<UserDto> update(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<UserDto> delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findAllLikes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findAllTweets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findAllComments() {
		// TODO Auto-generated method stub
		return null;
	}

}
