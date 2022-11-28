package com.company.twitterClone.Services.Concrete;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.ErrorResultData;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Core.Utilities.Result.SuccessResultData;
import com.company.twitterClone.Core.Utilities.Validation.Concrete.UserValidation;
import com.company.twitterClone.Models.Response.UserResponse;
import com.company.twitterClone.Repositories.UserRepository;
import com.company.twitterClone.Services.Abstract.IUserService;

@Service
public class UserManager implements IUserService<UserResponse> {
	private UserRepository userRepository;
	private UserValidation userValidation;

	public UserManager(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	@Override
	public DataResult<UserResponse> findOne(Long id) {
		try {
			var user = userValidation.validationRequest(id);

			UserResponse userResponse = new UserResponse();

			userResponse.setDisplayName(user.getDisplayName());
			userResponse.setId(user.getId());
			userResponse.setUsername(user.getUsername());
			userResponse.setProfileImage(user.getProfileImage());

			return new SuccessResultData<UserResponse>(userResponse);

		} catch (Exception ex) {
			return new ErrorResultData<UserResponse>(ex.toString());
		}

	}

	@Override
	public DataResult<List<UserResponse>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<UserResponse> update(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<UserResponse> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findAllLikes(Long id) {
		try {
			var user = userValidation.validationRequest(id);
			return null;
		} catch (Exception ext) {
			return null;
		}
	}

	@Override
	public Result findAllTweets(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findAllComments(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
