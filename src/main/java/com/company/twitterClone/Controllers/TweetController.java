package com.company.twitterClone.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Dtos.TweetCreateDto;
import com.company.twitterClone.Models.Dtos.TweetDto;
import com.company.twitterClone.Services.Concrete.AuthManager;
import com.company.twitterClone.Services.Concrete.TweetManager;

@RestController()
@RequestMapping("/api/tweet")
public class TweetController {

	TweetManager tweetManager;

	public TweetController(TweetManager tweetManager) {
		this.tweetManager = tweetManager;
	}

	@PostMapping("/")
	public Result createTweet(@Valid @RequestBody TweetCreateDto tweetCreateDto) {
		return tweetManager.createTweet(tweetCreateDto);
	}
	
	@PostMapping("/edit")
	public DataResult<TweetDto> updateTweet(@Valid @RequestBody TweetDto tweetDto){
		return tweetManager.update(tweetDto.getUser().getId());
	}
}
