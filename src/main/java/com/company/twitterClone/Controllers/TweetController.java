package com.company.twitterClone.Controllers;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Concrete.Tweet;
import com.company.twitterClone.Models.Dtos.TweetDto;
import com.company.twitterClone.Models.Dtos.UserDto;
import com.company.twitterClone.Services.Concrete.LikeManager;
import com.company.twitterClone.Services.Concrete.TweetManager;

@RestController()
@RequestMapping("/api/tweet")
public class TweetController {

	TweetManager tweetManager;
	LikeManager likeManager;

	public TweetController(TweetManager tweetManager, LikeManager likeManager) {
		this.tweetManager = tweetManager;
		this.likeManager = likeManager;
	}

	@PostMapping("/")
	public Result createTweet(@Valid @RequestBody Tweet tweet, long userId) throws Exception {
		return tweetManager.createTweet(tweet, userId);
	}

	@PostMapping("/createComment")
	public Result createComment(@Valid @RequestBody Tweet comment, long userId, long tweetId) {
		return tweetManager.createComment(comment, userId, tweetId);
	}

	@PostMapping("/findOneTweet")
	public DataResult<TweetDto> findOneTweet(@Valid @RequestBody long id) throws Exception {
		return tweetManager.findOne(id);
	}

	@PostMapping("/edit")
	public DataResult<TweetDto> updateTweet(@Valid @RequestBody TweetDto tweetDto) {
		return tweetManager.update(tweetDto.getUser().getId());
	}

	@PostMapping("/likeToPost")
	public Result likeTweet(@Valid @RequestBody long tweetId, long userId) {
		return likeManager.likeTweet(tweetId, userId);
	}

//	@PostMapping("/likeComment")
//	public Result likeComment(@Valid @RequestBody long commentId, long userId) {
//		return likeManager.likeComment(commentId, userId);
//	}
}
