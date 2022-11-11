package com.company.twitterClone.Core.BusinessRules.Abstract;

public interface IBusinessRules<T> {
	boolean isValidId(long id);
	boolean validationRequest(T data);
}
