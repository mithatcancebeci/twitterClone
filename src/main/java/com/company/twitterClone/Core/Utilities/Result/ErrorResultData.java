package com.company.twitterClone.Core.Utilities.Result;

public class ErrorResultData<T> extends DataResult<T> {
	public ErrorResultData(T data) {
		super(data, false);
	}

	public ErrorResultData(T data, String message) {
		super(data, false, message);
	}

	public ErrorResultData(String message) {
		super(null, false, message);
	}

	public ErrorResultData() {
		super(null, false);
	}
}
