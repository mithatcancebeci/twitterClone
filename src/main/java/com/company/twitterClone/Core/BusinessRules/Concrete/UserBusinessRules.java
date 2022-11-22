package com.company.twitterClone.Core.BusinessRules.Concrete;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.BusinessRules.Abstract.IBusinessRules;
import com.company.twitterClone.Models.Concrete.User;

@Service
public class UserBusinessRules implements IBusinessRules<User> {

	@Override
	public boolean validationRequest(User data) {
		// TODO Auto-generated method stub
		return false;
	}

}
