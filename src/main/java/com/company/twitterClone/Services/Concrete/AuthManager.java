package com.company.twitterClone.Services.Concrete;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Concrete.User;
import com.company.twitterClone.Models.Request.UserLoginRequest;
import com.company.twitterClone.Models.Request.UserRegisterRequest;
import com.company.twitterClone.Repository.UserRepository;
import com.company.twitterClone.Services.Abstract.IAuthService;

@Service
public class AuthManager implements IAuthService {

	private UserRepository userRepository;

	public AuthManager(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Result login(UserLoginRequest user) {
		try {
			if (user == null) {
				return new Result(false, "User credentials cannot be null");
			}
			boolean isUserInDB = false;
			if (!isUserInDB) {
				return new Result(false, "Please check your credentials");
			}
			return new Result(true, "Login is success");
		} catch (Exception ex) {
			return new Result(false, ex.toString());
		}

	}

	@Override
	public Result register(UserRegisterRequest registerInfo) {
		try {
			if (registerInfo == null) {
				return new Result(false, "Register is failure");
			}

			var userInDB = userRepository.findByEmail(registerInfo.getEmail());

			if (userInDB != null) {
				return new Result(false, "User email has been already use");
			}

			User user = new User();

			user.setUsername(registerInfo.getUsername());
			user.setDisplayName(registerInfo.getDisplayName());
			user.setBirthDateYear(registerInfo.getBirthDateYear());
			user.setPassword(registerInfo.getPassword());
			user.setLocation(registerInfo.getLocation());
			user.setEmail(registerInfo.getEmail());
			user.setProfileImage(registerInfo.getProfileImage());

			userRepository.save(user);

			return new Result(true, "Success");

		} catch (Exception ex) {

			return new Result(false, ex.toString());
		}

	}

	@Override
	public Result changePassword(UserRegisterRequest user) {
		// TODO Auto-generated method stub
		return null;
	}

}
