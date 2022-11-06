package com.company.twitterClone.Controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.twitterClone.Core.Utilities.Result.Result;

@RestController("/api/user")
public class UserController {

	@PostMapping("/getUser")
	public Result findById(@Valid @RequestBody long id) {
		return new Result(true);
	}

	@PostMapping("/getFollowers")
	public Result getFollowers(@Valid @RequestBody long id) {
		return new Result(true);
	}
}
