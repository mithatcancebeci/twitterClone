package com.company.twitterClone.Core.Utilities.Validation;

public class Validation {
	public boolean emailValidation(String email) {
		return false;
	}

	public boolean phoneValidation(String phone) {
		return false;
	}

	public boolean checkEntityId(long id) {
		if (id <= 0) {
			return false;
		}
		return true;
	}

}
