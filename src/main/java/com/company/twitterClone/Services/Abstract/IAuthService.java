package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Request.UserLoginRequest;
import com.company.twitterClone.Models.Request.UserRegisterRequest;

public interface IAuthService {

	Result login(UserLoginRequest user);

	Result register(UserRegisterRequest user);

	Result changePassword(UserRegisterRequest user);

}
