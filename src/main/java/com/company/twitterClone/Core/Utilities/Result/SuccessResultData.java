package com.company.twitterClone.Core.Utilities.Result;

public class SuccessResultData<T> extends DataResult<T> {

	public SuccessResultData(T data) {
		super(data, true);
		// TODO Auto-generated constructor stub
	}

	public SuccessResultData(T data, String message) {
		super(data, true, message);
		// TODO Auto-generated constructor stub
	}

	public SuccessResultData(String message) {
		super(null, true, message);
		// TODO Auto-generated constructor stub
	}

	public SuccessResultData() {
		super(null, true);
		// TODO Auto-generated constructor stub
	}

}
