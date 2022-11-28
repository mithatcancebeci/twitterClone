package com.company.twitterClone.Controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Request.UserLoginRequest;
import com.company.twitterClone.Models.Request.UserRegisterRequest;
import com.company.twitterClone.Services.Concrete.AuthManager;

@CrossOrigin()
@RestController()
@RequestMapping(value = "/api/auth")
public class AuthController {

	private AuthManager authManager;

	public AuthController(AuthManager authManager) {
		this.authManager = authManager;
	}

	@PostMapping("/login")
	Result login(@Valid @RequestBody UserLoginRequest user) {
		return authManager.login(user);
	}

	@PostMapping("/register")
	Result register(@Valid @RequestBody UserRegisterRequest user) {
		return authManager.register(user);
	}
}
