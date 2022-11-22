package com.company.twitterClone.Core.BusinessRules.Concrete;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.BusinessRules.Abstract.IBusinessRules;
import com.company.twitterClone.Models.Concrete.Tweet;

@Service
public class TweetBusinessRules implements IBusinessRules<Tweet> {

	@Override
	public boolean validationRequest(Tweet data) {
		// TODO Auto-generated method stub
		return false;
	}

}
