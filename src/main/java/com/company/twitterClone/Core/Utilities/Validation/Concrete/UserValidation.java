package com.company.twitterClone.Core.Utilities.Validation.Concrete;

import com.company.twitterClone.Core.Exception.NotFoundException;
import com.company.twitterClone.Core.Utilities.Validation.Abstract.IValidator;
import com.company.twitterClone.Models.Concrete.User;
import com.company.twitterClone.Repository.UserRepository;

public class UserValidation implements IValidator<User> {
	private UserRepository userRepository;

	public UserValidation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User validationRequest(Long id) {
		if (id <= 0 || id == null) {
			throw new NotFoundException("User was not found ");
		}
		var userInDB = userRepository.findById(id);

		if (userInDB == null) {
			throw new NotFoundException("User was not found");
		}

		return userInDB.get();
	}

}
