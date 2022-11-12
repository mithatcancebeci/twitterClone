package com.company.twitterClone.Core.BusinessRules.Concrete;

public class BaseBusinessRules {

	public boolean isValidId(long id) {
		if (id <= 0) {
			return false;
		}
		return true;
	}

}
