package com.company.twitterClone.Services.Concrete;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Concrete.User;
import com.company.twitterClone.Models.Dtos.UserLoginDto;
import com.company.twitterClone.Models.Dtos.UserRegisterDto;
import com.company.twitterClone.Repository.UserRepository;
import com.company.twitterClone.Services.Abstract.IAuthService;

@Service
public class AuthManager implements IAuthService {

	UserRepository userRepository;

	public AuthManager(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Result login(UserLoginDto user) {
		try {
			if (user == null) {
				return new Result(false, "User credentials cannot be null");
			}
			boolean isUserInDB = checkEmailAndPassword(user);
			if (!isUserInDB) {
				return new Result(false, "Please check your credentials");
			}
			return new Result(true, "Login is success");
		} catch (Exception ex) {
			return new Result(false, ex.toString());
		}

	}

	@Override
	public Result register(UserRegisterDto userDto) {
		try {
			if (userDto == null) {
				return new Result(false, "Register is failure");
			}

			var userInDB = userRepository.findUserByEmail(userDto.getEmail());

			if (userInDB != null) {
				return new Result(false, "User email has been already use");
			}

			String displayName = createDisplayName(userDto.getName(), userDto.getSurname());

			User user = new User();
			user.setName(userDto.getName());
			user.setSurname(userDto.getSurname());
			user.setBirthDateYear(userDto.getBirthDateYear());
			user.setDisplayName(displayName);
			user.setPassword(userDto.getPassword());
			user.setLocation(userDto.getLocation());
			user.setEmail(userDto.getEmail());
			user.setProfileImage(userDto.getProfileImage());

			userRepository.save(user);

			return new Result(true, "Success");
		} catch (Exception ex) {
			return new Result(false, ex.toString());
		}

	}

	@Override
	public Result changePassword(UserRegisterDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	private String createDisplayName(String name, String surname) {
		String displayName = null;
		if (name != null && surname != null) {
			displayName = "@" + surname + name;
		}
		return displayName;
	}

	private boolean checkEmailAndPassword(UserLoginDto user) {
		var userInDB = userRepository.findUserByEmail(user.getEmail());
		if (userInDB != null) {
			boolean hasEmail = user.getEmail().equals(userInDB.getEmail());
			boolean isCorrectPassword = user.getPassword().equals(userInDB.getPassword());
			// next step encryption
			if (hasEmail && isCorrectPassword) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
