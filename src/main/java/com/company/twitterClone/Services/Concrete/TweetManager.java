package com.company.twitterClone.Services.Concrete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.Exception.NotFoundException;
import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.ErrorResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Core.Utilities.Result.SuccessResult;
import com.company.twitterClone.Core.Utilities.Result.SuccessResultData;
import com.company.twitterClone.Core.Utilities.Validation.Concrete.TweetValidation;
import com.company.twitterClone.Core.Utilities.Validation.Concrete.UserValidation;
import com.company.twitterClone.Models.Concrete.Like;
import com.company.twitterClone.Models.Concrete.Tweet;
import com.company.twitterClone.Models.Request.CreateCommentRequest;
import com.company.twitterClone.Models.Request.CreateLikeRequest;
import com.company.twitterClone.Models.Request.CreateTweetRequest;
import com.company.twitterClone.Models.Response.LikeResponse;
import com.company.twitterClone.Models.Response.ReTweetResponse;
import com.company.twitterClone.Models.Response.TweetResponse;
import com.company.twitterClone.Models.Response.UserResponse;
import com.company.twitterClone.Repository.LikeRepository;
import com.company.twitterClone.Repository.TweetRepository;
import com.company.twitterClone.Repository.UserRepository;
import com.company.twitterClone.Services.Abstract.ITweetService;

@Service
public class TweetManager implements ITweetService<TweetResponse> {

	private TweetRepository tweetRepository;
	private UserRepository userRepository;
	private TweetValidation tweetValidation;
	private UserValidation userValidation;
	private LikeRepository likeRepository;

	public TweetManager(TweetRepository tweetRepository, UserRepository userRepository, LikeRepository likeRepository) {
		this.tweetRepository = tweetRepository;
		this.userRepository = userRepository;
		this.likeRepository = likeRepository;
	}

	@Override
	public DataResult<TweetResponse> findOne(Long tweetId) throws Exception {
		try {

			var tweet = tweetValidation.validationRequest(tweetId);

			var user = tweet.getUser();

			if (user == null) {
				throw new NotFoundException("user was not found");
			}

			TweetResponse tweetResponse = new TweetResponse();

			var convertedComments = this.convertComments(tweet);
			tweetResponse.setComments(convertedComments);

			var convertedLikes = this.convertLikes(tweet);
			tweetResponse.setLikes(convertedLikes);

			var convertedReTweets = this.convertReTweets(tweet);
			tweetResponse.setReTweets(convertedReTweets);

			tweetResponse.setContent(tweet.getContent());
			tweetResponse.setCreatedAt(tweet.getCreatedAt());
			tweetResponse.setUpdatedAt(tweet.getUpdatedAt());
			tweetResponse.setId(tweet.getId());
			tweetResponse.setUser(new UserResponse(user));

			return new SuccessResultData<>(tweetResponse);
		} catch (Exception e) {
			throw new Exception(e.toString());
		}

	}

	@Override
	public DataResult<List<TweetResponse>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<TweetResponse> update(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<TweetResponse> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result likeTweet(CreateLikeRequest likeInfo) {
		try {
			var tweet = tweetValidation.validationRequest(likeInfo.getTweetId());
			var user = userValidation.validationRequest(likeInfo.getUserId());

			Like like = new Like();

			int currentLikeCount = tweet.getLikeCount();
			tweet.setLikeCount(currentLikeCount + 1);

			like.setTweet(tweet);
			like.setUser(user);

			var getLikesCurrentTweet = tweet.getLikes();
			var getLikesCurrentUser = user.getLikes();

			getLikesCurrentUser.add(like);
			getLikesCurrentTweet.add(like);

			tweet.setLikes(getLikesCurrentTweet);
			user.setLikes(getLikesCurrentUser);

			likeRepository.save(like);
			tweetRepository.save(tweet);
			userRepository.save(user);

			return new SuccessResult("Tweet liked");

		} catch (Exception ex) {
			return new ErrorResult(ex.toString());
		}

	}

	@Override
	public Result unlikeTweet(CreateLikeRequest unLikeInfo) {
		try {

			var tweet = tweetValidation.validationRequest(unLikeInfo.getTweetId());
			var user = userValidation.validationRequest(unLikeInfo.getUserId());

			var likeListForTweet = tweet.getLikes();
			int currentLikeCount = tweet.getLikeCount();

			tweet.setLikeCount(currentLikeCount - 1);

			Like like = new Like();

			for (int i = 0; i < likeListForTweet.size(); i++) {
				boolean checkUser = likeListForTweet.get(i).getUser().getId() == user.getId();
				boolean checkTweet = likeListForTweet.get(i).getTweet().getId() == tweet.getId();
				if (checkTweet && checkUser) {
					likeListForTweet.remove(i);
					like = likeListForTweet.get(i);
				}
			}

			tweetRepository.save(tweet);

			var likeListForUser = user.getLikes();

			for (int i = 0; i < likeListForUser.size(); i++) {
				boolean checkUser = likeListForUser.get(i).getUser().getId() == user.getId();
				if (checkUser) {
					likeListForUser.remove(i);
				}
			}

			userRepository.save(user);

			likeRepository.delete(like);

			return new SuccessResult("unlike success");
		} catch (Exception ex) {
			return new ErrorResult(ex.toString());
		}
	}

	@Override
	public Result findAllComments() {
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
	public Result createComment(CreateCommentRequest commentInfo) {
		try {
			var tweet = tweetValidation.validationRequest(commentInfo.getTweetId());
			var user = userValidation.validationRequest(commentInfo.getUserId());

			Tweet comment = new Tweet();
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
	public Result createTweet(CreateTweetRequest tweetInfo) {
		try {
			if (tweetInfo.getContent() == null) {
				return new ErrorResult("Tweet cannot be null");
			}

			var user = userValidation.validationRequest(tweetInfo.getUserId());

			Tweet tweet = new Tweet();

			tweet.setCreatedAt(new java.util.Date());
			tweet.setUpdatedAt(new java.util.Date());
			tweet.setComments(null);
			tweet.setLikes(null);
			tweet.setContent(tweetInfo.getContent());
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

	private List<TweetResponse> convertComments(Tweet tweet) {
		List<TweetResponse> comments = new ArrayList<>();
		if (tweet.getComments() != null) {
			for (int i = 0; i < tweet.getComments().size(); i++) {
				comments.add(new TweetResponse(tweet.getComments().get(i)));
			}
		}
		return comments;

	}

	private List<LikeResponse> convertLikes(Tweet tweet) {
		List<LikeResponse> likes = new ArrayList<>();
		if (tweet.getLikes() != null) {
			for (int i = 0; i < tweet.getLikes().size(); i++) {
				likes.add(new LikeResponse(tweet.getLikes().get(i)));
			}
		}
		return likes;

	}

	private List<ReTweetResponse> convertReTweets(Tweet tweet) {
		List<ReTweetResponse> reTweets = new ArrayList<>();
		if (tweet.getReTweets() != null) {
			for (int i = 0; i < tweet.getReTweets().size(); i++) {
				reTweets.add(new ReTweetResponse(tweet.getReTweets().get(i)));
			}
		}
		return reTweets;

	}

}
