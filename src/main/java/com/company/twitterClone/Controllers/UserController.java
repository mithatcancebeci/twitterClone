package com.company.twitterClone.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Dtos.CommentDto;
import com.company.twitterClone.Models.Dtos.LikeDto;
import com.company.twitterClone.Services.Concrete.CommentManager;
import com.company.twitterClone.Services.Concrete.UserManager;

@RestController("/api/user")
public class UserController {
	UserManager userManager;
	CommentManager commentManager;

	public UserController(UserManager userManager, CommentManager commentManager) {
		this.userManager = userManager;
		this.commentManager = commentManager;
	}

	@PostMapping("/getUser")
	public Result findById(@Valid @RequestBody long id) {
		return new Result(true);
	}

	@PostMapping("/getFollowers")
	public Result getFollowers(@Valid @RequestBody long id) {
		return new Result(true);
	}

	@PostMapping("/getAllComments")
	public List<CommentDto> getAllComments(@Valid @RequestBody long id) throws Exception {
		return commentManager.findAllCommentsByUser(id);
	}
	@PostMapping("/getAllLikes")
	public List<LikeDto> getAllLikes(@Valid @RequestBody long id) throws Exception{
		return commentManager.
	}
}
