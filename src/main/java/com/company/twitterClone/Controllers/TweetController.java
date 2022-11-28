package com.company.twitterClone.Controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Request.CreateCommentRequest;
import com.company.twitterClone.Models.Request.CreateLikeRequest;
import com.company.twitterClone.Models.Request.CreateTweetRequest;
import com.company.twitterClone.Models.Response.TweetResponse;
import com.company.twitterClone.Services.Concrete.TweetManager;

@CrossOrigin()
@RestController()
@RequestMapping(value = "/api/tweet")
public class TweetController {

	private TweetManager tweetManager;

	public TweetController(TweetManager tweetManager) {
		this.tweetManager = tweetManager;
	}

	@PostMapping("/")
	public Result createTweet(@Valid @RequestBody CreateTweetRequest tweetInfo) throws Exception {

		return tweetManager.createTweet(tweetInfo);
	}

	@PostMapping("/createComment")
	public Result createComment(@Valid @RequestBody CreateCommentRequest commentInfo) {
		return tweetManager.createComment(commentInfo);
	}

	@PostMapping("/{id:[0-9]+}")
	public DataResult<TweetResponse> findOneTweet(@Valid @PathVariable long id) throws Exception {
		return tweetManager.findOne(id);
	}

	@PostMapping("/edit")
	public DataResult<TweetResponse> updateTweet(@Valid @RequestBody TweetResponse tweetDto) {
		return tweetManager.update(tweetDto.getUser().getId());
	}

	@PostMapping("/likeTweet")
	public Result likeTweet(@Valid @RequestBody CreateLikeRequest likeInfo) {
		return tweetManager.likeTweet(likeInfo);
	}

	@PostMapping("/unlikeTweet")
	public Result unlikeTweet(@Valid @RequestBody CreateLikeRequest unlikeInfo) {
		return tweetManager.unlikeTweet(unlikeInfo);
	}
}
