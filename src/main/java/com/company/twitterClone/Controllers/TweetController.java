package com.company.twitterClone.Controllers;


import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Dtos.CreateCommentDto;
import com.company.twitterClone.Models.Dtos.CreateLikeDto;
import com.company.twitterClone.Models.Dtos.CreateTweetDto;
import com.company.twitterClone.Models.Dtos.TweetDto;
import com.company.twitterClone.Services.Concrete.TweetManager;

@CrossOrigin()
@RestController()
@RequestMapping(value = "/api/tweet")
public class TweetController {

	TweetManager tweetManager;
	
	public TweetController(TweetManager tweetManager) {
		this.tweetManager = tweetManager;
	}

	@PostMapping("/")
	public Result createTweet(@Valid @RequestBody CreateTweetDto tweetInfo) throws Exception {

		return tweetManager.createTweet(tweetInfo);
	}

	@PostMapping("/createComment")
	public Result createComment(@Valid @RequestBody CreateCommentDto commentInfo) {
		return tweetManager.createComment(commentInfo);
	}

	@PostMapping("/findOneTweet")
	public DataResult<TweetDto> findOneTweet(@Valid @RequestBody long id) throws Exception {
		return tweetManager.findOne(id);
	}

	@PostMapping("/edit")
	public DataResult<TweetDto> updateTweet(@Valid @RequestBody TweetDto tweetDto) {
		return tweetManager.update(tweetDto.getUser().getId());
	}

	@PostMapping("/likeTweet")
	public Result likeTweet(@Valid @RequestBody CreateLikeDto likeInfo) {
		return tweetManager.likeTweet(likeInfo);
	}

	@PostMapping("/unlikeTweet")
	public Result unlikeTweet(@Valid @RequestBody CreateLikeDto unlikeInfo) {
		return tweetManager.unlikeTweet(unlikeInfo);
	}
}
