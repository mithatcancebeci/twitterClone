package com.company.twitterClone.Services.Concrete;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.Exception.NotFoundException;
import com.company.twitterClone.Core.Utilities.Result.ErrorResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Core.Utilities.Result.SuccessResult;
import com.company.twitterClone.Core.Utilities.Validation.Validation;
import com.company.twitterClone.Models.Concrete.Like;
import com.company.twitterClone.Repository.LikeRepository;
import com.company.twitterClone.Repository.TweetRepository;
import com.company.twitterClone.Repository.UserRepository;
import com.company.twitterClone.Services.Abstract.ILikeService;

@Service
public class LikeManager implements ILikeService {
	TweetRepository tweetRepository;
	UserRepository userRepository;
	LikeRepository likeRepository;
	Validation validation;

	public LikeManager(UserRepository userRepository, TweetRepository tweetRepository, LikeRepository likeRepository) {
		this.userRepository = userRepository;
		this.tweetRepository = tweetRepository;
		this.likeRepository = likeRepository;

	}

	@Override
	public Result likeTweet(long tweetId, long userId) {
		try {
			if (!validation.checkEntityId(tweetId) || validation.checkEntityId(userId)) {
				throw new NotFoundException("tweet was not found");
			}

			var tweet = tweetRepository.findById(tweetId).get();
			var user = userRepository.findById(userId).get();

			if (tweet == null || user == null) {
				throw new NotFoundException("tweet was not found");
			}

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
	public Result unLikeTweet(long tweetId, long userId) {
		try {
			if (!validation.checkEntityId(tweetId) || !validation.checkEntityId(userId)) {
				throw new NotFoundException("tweet was not found");
			}

			var tweet = tweetRepository.findById(tweetId).get();
			var user = userRepository.findById(userId).get();
			if (tweet == null || user == null) {
				throw new NotFoundException("tweet was not found");
			}

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
	public Result getAllLikesByUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getAllLikesInTweet(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
