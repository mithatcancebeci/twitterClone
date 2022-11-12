package com.company.twitterClone.Core.BusinessRules.Abstract;

public interface IBusinessRules<T> {
	boolean validationRequest(T data);
}
