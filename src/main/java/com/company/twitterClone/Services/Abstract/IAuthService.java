package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Dtos.UserLoginDto;
import com.company.twitterClone.Models.Dtos.UserRegisterDto;

public interface IAuthService {

	Result login(UserLoginDto user);

	Result register(UserRegisterDto user);

	Result changePassword(UserRegisterDto user);

}
