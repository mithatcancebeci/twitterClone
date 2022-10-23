package com.company.twitterClone.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Dtos.UserLoginDto;
import com.company.twitterClone.Models.Dtos.UserRegisterDto;
import com.company.twitterClone.Services.Concrete.AuthManager;
import javax.validation.Valid;

@RestController()
@RequestMapping("/api/auth")
public class AuthController {

	AuthManager authManager;

	public AuthController(AuthManager authManager) {
		this.authManager = authManager;
	}

	@PostMapping("/login")
	Result login(@Valid @RequestBody UserLoginDto user) {
		return authManager.login(user);
	}

	@PostMapping("/register")
	Result register(@Valid @RequestBody UserRegisterDto user) {
		return authManager.register(user);
	}
}
