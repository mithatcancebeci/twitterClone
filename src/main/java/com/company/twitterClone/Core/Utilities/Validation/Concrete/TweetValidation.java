package com.company.twitterClone.Core.Utilities.Validation.Concrete;

import com.company.twitterClone.Core.Exception.NotFoundException;
import com.company.twitterClone.Core.Utilities.Validation.Abstract.IValidator;
import com.company.twitterClone.Models.Concrete.Tweet;
import com.company.twitterClone.Repositories.TweetRepository;

public class TweetValidation implements IValidator<Tweet> {

	private TweetRepository tweetRepository;

	public TweetValidation(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}

	@Override
	public Tweet validationRequest(Long id) {
		if (id <= 0 || id == null) {
			throw new NotFoundException("Tweet was not found");
		}
		var tweetInDB = tweetRepository.findById(id);

		if (tweetInDB == null) {
			throw new NotFoundException("Tweet was not found");
		}

		return tweetInDB.get();
	}

}
