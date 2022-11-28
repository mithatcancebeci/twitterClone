package com.company.twitterClone.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.company.twitterClone.Services.Concrete.UserManager;

@RestController("/api/user")
public class UserController {
	private UserManager userManager;

	public UserController(UserManager userManager) {
		this.userManager = userManager;
	}

}
