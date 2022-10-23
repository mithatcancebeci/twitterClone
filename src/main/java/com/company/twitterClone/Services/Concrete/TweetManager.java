package com.company.twitterClone.Services.Concrete;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Dtos.TweetCreateDto;
import com.company.twitterClone.Models.Dtos.TweetDto;
import com.company.twitterClone.Models.Dtos.UserDto;
import com.company.twitterClone.Repository.TweetRepository;
import com.company.twitterClone.Repository.UserRepository;
import com.company.twitterClone.Services.Abstract.ITweetService;
import com.company.twitterClone.Models.Concrete.Tweet;
import com.company.twitterClone.Models.Concrete.User;

@Service
public class TweetManager implements ITweetService {

	TweetRepository tweetRepository;
	UserRepository userRepository;

	public TweetManager(TweetRepository tweetRepository, UserRepository userRepository) {
		this.tweetRepository = tweetRepository;
		this.userRepository = userRepository;
	}

	@Override
	public DataResult<TweetDto> findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<TweetDto>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<TweetDto> update(long id) {
		return null;
	}

	@Override
	public DataResult<TweetDto> delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findAllComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findOneComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findAllLikes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findOneLike() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result createTweet(TweetCreateDto tweetCreateDto) {
		try {
			if (tweetCreateDto == null) {
				return new Result(false, "Tweet cannot be null");
			}

			UserDto userDto = tweetCreateDto.getUser();
			var user = userRepository.findUserByDisplayName(userDto.getDisplayName());

			if (user == null) {
				return new Result(false, "user cannot be null");
			}

			Tweet tweet = new Tweet();
			tweet.setContent(tweetCreateDto.getContent());
			tweet.setCreatedAt(new java.util.Date());
			tweet.setUpdatedAt(new java.util.Date());

			user.getTweets().add(tweet);
			tweet.setUser(user);
			tweetRepository.save(tweet);

			return new Result(true, "Tweet is created");

		} catch (Exception ex) {
			return new Result(false, ex.toString());
		}
	}

}
