package com.company.twitterClone.Services.Concrete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.Exception.NotFoundException;
import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Core.Utilities.Result.SuccessResultData;
import com.company.twitterClone.Models.Dtos.CommentDto;
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

	public TweetManager(TweetRepository tweetRepository, UserRepository userRepository) {
		this.tweetRepository = tweetRepository;
		this.userRepository = userRepository;
	}

	@Override
	public DataResult<TweetDto> findOne(long id) throws Exception {
		if (id <= 0) {
			throw new NotFoundException("Tweet was not found");
		}

		var tweetInDB = tweetRepository.findById(id);

		if (tweetInDB == null) {
			throw new NotFoundException("Tweet was not found");
		}

		var user = tweetInDB.get().getUser();

		if (user == null) {
			throw new NotFoundException("Tweet was not found");
		}

		var tweet = tweetInDB.get();

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
	public Result createTweet(Tweet tweet) {
		try {
			if (tweet == null) {
				return new Result(false, "Tweet cannot be null");
			}

			if (tweet.getUser() == null) {
				return new Result(false, "User is not logged in");
			}
			User user = tweet.getUser();
			var userInDB = userRepository.findUserByDisplayName(user.getDisplayName());

			if (userInDB == null) {
				throw new NotFoundException("User was not found");
			}

			tweet.setCreatedAt(new java.util.Date());
			tweet.setUpdatedAt(new java.util.Date());
			tweet.setComments(null);
			tweet.setLikes(null);
			tweet.setReTweets(null);
			tweet.setReTweetCount(0);
			tweet.setLikeCount(0);
			tweet.setUser(user);
			tweetRepository.save(tweet);

			return new Result(true, "Tweet is created");

		} catch (Exception ex) {
			return new Result(false, ex.toString());
		}

	}

	private List<CommentDto> convertComments(Tweet tweet) {
		List<CommentDto> comments = new ArrayList<CommentDto>();
		if (tweet.getComments() != null) {
			for (int i = 0; i < tweet.getComments().size(); i++) {
				comments.add(new CommentDto(tweet.getComments().get(i)));
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
