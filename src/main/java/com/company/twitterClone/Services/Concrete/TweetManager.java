package com.company.twitterClone.Services.Concrete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.BusinessRules.Concrete.TweetBusinessRules;
import com.company.twitterClone.Core.BusinessRules.Concrete.UserBusinessRules;
import com.company.twitterClone.Core.Exception.NotFoundException;
import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.ErrorResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Core.Utilities.Result.SuccessResult;
import com.company.twitterClone.Core.Utilities.Result.SuccessResultData;
import com.company.twitterClone.Models.Dtos.LikeDto;
import com.company.twitterClone.Models.Dtos.ReTweetDto;
import com.company.twitterClone.Models.Dtos.TweetDto;
import com.company.twitterClone.Models.Dtos.UserDto;
import com.company.twitterClone.Repository.TweetRepository;
import com.company.twitterClone.Repository.UserRepository;
import com.company.twitterClone.Services.Abstract.ITweetService;
import com.company.twitterClone.Models.Concrete.Tweet;
import com.company.twitterClone.Models.Concrete.User;

@Service
public class TweetManager implements ITweetService<TweetDto> {

	TweetRepository tweetRepository;
	UserRepository userRepository;
	UserBusinessRules userBusinessRules;
	TweetBusinessRules tweetBusinessRules;

	public TweetManager(TweetRepository tweetRepository, UserRepository userRepository) {
		this.tweetRepository = tweetRepository;
		this.userRepository = userRepository;
	}

	@Override
	public DataResult<TweetDto> findOne(long id) throws Exception {
		if (!tweetBusinessRules.isValidId(id)) {
			throw new NotFoundException("Tweet was not found");
		}

		var tweet = tweetRepository.findById(id).get();
		var user = tweet.getUser();
		if (tweet == null || user == null) {
			throw new NotFoundException("User or tweet not found");
		}
		
		TweetDto tweetDto = new TweetDto();

		var convertedComments = this.convertComments(tweet);
		tweetDto.setComments(convertedComments);

		var convertedLikes = this.convertLikes(tweet);
		tweetDto.setLikes(convertedLikes);

		var convertedReTweets = this.convertReTweets(tweet);
		tweetDto.setReTweets(convertedReTweets);

		tweetDto.setContent(tweet.getContent());
		tweetDto.setCreatedAt(tweet.getCreatedAt());
		tweetDto.setUpdatedAt(tweet.getUpdatedAt());
		tweetDto.setId(tweet.getId());
		tweetDto.setUser(new UserDto(user));
		
		return new SuccessResultData<TweetDto>(tweetDto);
	}

	@Override
	public DataResult<List<TweetDto>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<TweetDto> update(long id) {
		// TODO Auto-generated method stub
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
	public Result createComment(Tweet comment, long userId, long tweetId) {
		try {
			if (!userBusinessRules.isValidId(userId) || !tweetBusinessRules.isValidId(tweetId)) {
				return new ErrorResult();
			}

			var tweet = tweetRepository.findById(tweetId).get();
			var user = userRepository.findById(userId).get();

			if (tweet == null || user == null) {
				throw new NotFoundException("Tweet was not found");
			}

			comment.setComments(null);
			comment.setReTweets(null);
			comment.setLikes(null);
			comment.setLikeCount(0);
			comment.setReTweetCount(0);
			comment.setCreatedAt(new java.util.Date());
			comment.setUpdatedAt(new java.util.Date());
			comment.setUser(user);

			tweetRepository.save(comment);

			var commentListOfUser = user.getComments();
			commentListOfUser.add(comment);
			user.setComments(commentListOfUser);
			userRepository.save(user);

			var commentListOfTweet = tweet.getComments();
			commentListOfTweet.add(comment);
			tweet.setComments(commentListOfTweet);
			tweetRepository.save(tweet);

			return new SuccessResult("Comment created");

		} catch (Exception ex) {
			return new ErrorResult(ex.toString());
		}

	}

	@Override
	public Result createTweet(Tweet tweet, long userId) {
		try {
			if (tweet == null || tweet.getContent() == null) {
				return new ErrorResult("Tweet cannot be null");
			}

			var userInDB = userRepository.findById(userId);

			if (userInDB == null) {
				throw new NotFoundException("User was not found");
			}

			var user = userInDB.get();

			tweet.setCreatedAt(new java.util.Date());
			tweet.setUpdatedAt(new java.util.Date());
			tweet.setComments(null);
			tweet.setLikes(null);
			tweet.setReTweets(null);
			tweet.setReTweetCount(0);
			tweet.setLikeCount(0);
			tweet.setUser(user);

			tweetRepository.save(tweet);

			return new SuccessResult("Tweet is created");

		} catch (Exception ex) {
			return new ErrorResult(ex.toString());
		}

	}

	private List<TweetDto> convertComments(Tweet tweet) {
		List<TweetDto> comments = new ArrayList<TweetDto>();
		if (tweet.getComments() != null) {
			for (int i = 0; i < tweet.getComments().size(); i++) {
				comments.add(new TweetDto(tweet.getComments().get(i)));
			}
		}
		return comments;

	}

	private List<LikeDto> convertLikes(Tweet tweet) {
		List<LikeDto> likes = new ArrayList<LikeDto>();
		if (tweet.getLikes() != null) {
			for (int i = 0; i < tweet.getLikes().size(); i++) {
				likes.add(new LikeDto(tweet.getLikes().get(i)));
			}
		}
		return likes;

	}

	private List<ReTweetDto> convertReTweets(Tweet tweet) {
		List<ReTweetDto> reTweets = new ArrayList<ReTweetDto>();
		if (tweet.getReTweets() != null) {
			for (int i = 0; i < tweet.getReTweets().size(); i++) {
				reTweets.add(new ReTweetDto(tweet.getReTweets().get(i)));
			}
		}
		return reTweets;

	}

}
