package com.company.twitterClone.Services.Concrete;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.BusinessRules.Abstract.IBusinessRules;
import com.company.twitterClone.Core.BusinessRules.Concrete.TweetBusinessRules;
import com.company.twitterClone.Core.BusinessRules.Concrete.UserBusinessRules;
import com.company.twitterClone.Core.Utilities.Result.ErrorResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Core.Utilities.Result.SuccessResult;
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
	IBusinessRules businessRules;
//	UserBusinessRules userBusinessRules;
//	CommentBusinessRules commentBusinessRules;

	public LikeManager(UserRepository userRepository, TweetRepository tweetRepository, LikeRepository likeRepository) {
		this.userRepository = userRepository;
		this.tweetRepository = tweetRepository;
		this.likeRepository = likeRepository;

	}

	@Override
	public Result likeTweet(long tweetId, long userId) {
		try {
			if (!businessRules.isValidId(tweetId) || !businessRules.isValidId(userId)) {
				return new ErrorResult();
			}

			var tweet = tweetRepository.findById(tweetId).get();
			var user = userRepository.findById(userId).get();

			if (tweet == null || user == null) {
				return new ErrorResult();
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

//	public Result likeComment(long commentId, long userId) {
//		try {
//			if (!businessRules.isValidId(commentId) || !businessRules.isValidId(userId)) {
//				return new ErrorResult();
//			}
//
//			var comment = commentRepository.findById(commentId).get();
//			var user = userRepository.findById(userId).get();
//
//			if (comment == null || user == null) {
//				return new ErrorResult();
//			}
//
//			Like like = new Like();
//
//			int currentLikeCount = comment.getLikeCount();
//			comment.setLikeCount(currentLikeCount + 1);
//
//			like.setComment(comment);
//			like.setUser(user);
//
//			var getLikesCurrentTweet = comment.getLikes();
//			var getLikesCurrentUser = user.getLikes();
//
//			getLikesCurrentUser.add(like);
//			getLikesCurrentTweet.add(like);
//
//			comment.setLikes(getLikesCurrentTweet);
//			user.setLikes(getLikesCurrentUser);
//
//			likeRepository.save(like);
//			commentRepository.save(comment);
//			userRepository.save(user);
//
//			return new SuccessResult("Comment liked");
//
//		} catch (Exception ex) {
//			return new ErrorResult(ex.toString());
//		}
//
//	}

	@Override
	public Result unLike(long id) {
		// TODO Auto-generated method stub
		return null;
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
