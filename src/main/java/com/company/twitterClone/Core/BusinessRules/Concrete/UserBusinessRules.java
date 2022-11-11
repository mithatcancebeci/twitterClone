package com.company.twitterClone.Core.BusinessRules.Concrete;

import com.company.twitterClone.Core.BusinessRules.Abstract.IBusinessRules;
import com.company.twitterClone.Models.Concrete.User;
import com.company.twitterClone.Repository.UserRepository;

public class UserBusinessRules implements IBusinessRules<User> {
	UserRepository userRepository;

	public UserBusinessRules(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean isValidId(long id) {
		if (id <= 0) {
			return false;
		}

		return true;
	}

	@Override
	public boolean validationRequest(User data) {
		// TODO Auto-generated method stub
		return false;
	}

}
