package com.company.twitterClone.Core.Utilities.Result;

public class Result {
	private boolean isSuccess;
	private String message;

	public Result(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Result(boolean isSuccess, String message) {
		this(isSuccess);
		this.message = message;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public String getMessage() {
		return message;
	}

}
