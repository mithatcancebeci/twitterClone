package com.company.twitterClone.Controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Concrete.Comment;
import com.company.twitterClone.Models.Concrete.Tweet;
import com.company.twitterClone.Models.Dtos.CommentDto;
import com.company.twitterClone.Models.Dtos.TweetDto;
import com.company.twitterClone.Services.Concrete.CommentManager;
import com.company.twitterClone.Services.Concrete.TweetManager;

@RestController()
@RequestMapping("/api/tweet")
public class TweetController {

	TweetManager tweetManager;
	CommentManager commentManager;

	public TweetController(TweetManager tweetManager) {
		this.tweetManager = tweetManager;
	}

	@PostMapping("/")
	public Result createTweet(@Valid @RequestBody Tweet tweet) {
		return tweetManager.createTweet(tweet);
	}

	@PostMapping("/createComment")
	public Result createComment(@Valid @RequestBody Comment comment) throws Exception {
		return commentManager.createComment(comment);
	}

	@PostMapping("/findOneTweet")
	public DataResult<TweetDto> findOneTweet(@Valid @RequestBody long id) throws Exception {
		return tweetManager.findOne(id);
	}

	@PostMapping("/findOneComment")
	public DataResult<CommentDto> findOneComment(@Valid @RequestBody long id) throws Exception {
		return commentManager.findOne(id);
	}

	@PostMapping("/edit")
	public DataResult<TweetDto> updateTweet(@Valid @RequestBody TweetDto tweetDto) {
		return tweetManager.update(tweetDto.getUser().getId());
	}
}
