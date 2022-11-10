package com.company.twitterClone.Services.Concrete;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.Utilities.Result.Result;
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

	public LikeManager(UserRepository userRepository, TweetRepository tweetRepository, LikeRepository likeRepository) {
		this.userRepository = userRepository;
		this.tweetRepository = tweetRepository;
		this.likeRepository = likeRepository;
	}

	@Override
	public Result like(long id, long currentUserId) {
		try {
			if (id <= 0 || currentUserId <= 0) {
				return new Result(false);
			}
			Like like = new Like();
			var tweetInDB = tweetRepository.findById(id);
			var userInDB = userRepository.findById(currentUserId);
			var tweet = tweetInDB.get();
			var user = userInDB.get();

			if (tweet == null || user == null) {
				return new Result(false);
			}
			
			//Comment Eklenecek
			
			int currentLikeCount = tweet.getLikeCount();
			
			var getLikesCurrentTweet = tweet.getLikes();
			var getLikesCurrentUser = user.getLikes();
			getLikesCurrentUser.add(like);
			getLikesCurrentTweet.add(like);
			
			like.setTweet(tweet);
			like.setUser(user);
			likeRepository.save(like);
			
			tweet.setLikeCount(currentLikeCount + 1);
			tweet.setLikes(getLikesCurrentTweet);
			tweetRepository.save(tweet);
			
			user.setLikes(getLikesCurrentUser);
			userRepository.save(user);
			
		} catch (Exception ex) {

		}
		return null;
	}

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
