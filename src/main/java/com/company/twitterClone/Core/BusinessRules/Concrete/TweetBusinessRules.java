package com.company.twitterClone.Core.BusinessRules.Concrete;

import com.company.twitterClone.Core.BusinessRules.Abstract.IBusinessRules;
import com.company.twitterClone.Models.Concrete.Tweet;
import com.company.twitterClone.Repository.TweetRepository;

public class TweetBusinessRules implements IBusinessRules<Tweet> {

	TweetRepository tweetRepository;

	public TweetBusinessRules(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}

	@Override
	public boolean isValidId(long id) {
		if (id <= 0) {
			return false;
		}

		return true;
	}

	@Override
	public boolean validationRequest(Tweet data) {
		// TODO Auto-generated method stub
		return false;
	}

}
