package com.company.twitterClone.Services.Concrete;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.Exception.NotFoundException;
import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.ErrorDataResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Core.Utilities.Result.SuccessResultData;
import com.company.twitterClone.Core.Utilities.Validation.Validation;
import com.company.twitterClone.Models.Dtos.LikeDto;
import com.company.twitterClone.Models.Dtos.UserDto;
import com.company.twitterClone.Repository.UserRepository;
import com.company.twitterClone.Services.Abstract.IUserService;
import java.util.List;

@Service
public class UserManager implements IUserService<UserDto> {
	UserRepository userRepository;
	Validation validation;

	public UserManager(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public DataResult<UserDto> findOne(long id) {
		try {
			if (!validation.checkEntityId(id)) {
				throw new NotFoundException("user was not found");
			}

			var userInDb = userRepository.findById(id);

			if (userInDb == null) {
				throw new NotFoundException("user was not found");
			}

			var user = userInDb.get();

			UserDto userDto = new UserDto();

			userDto.setDisplayName(user.getDisplayName());
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			userDto.setProfileImage(user.getProfileImage());

			return new SuccessResultData<UserDto>(userDto);

		} catch (Exception ex) {
			System.out.println(ex.toString());
			return new ErrorDataResult<UserDto>();
		}

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
	public Result findAllLikes(long id) {
		try {
			if (!validation.checkEntityId(id)) {
				throw new NotFoundException("user was not found");
			}

			var userInDb = userRepository.findById(id);

			if (userInDb == null) {
				throw new NotFoundException("user was not found");
			}

			var user = userInDb.get();
			return null;
		} catch (Exception ext) {
			return null;
		}
	}

	@Override
	public Result findAllTweets(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findAllComments(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
