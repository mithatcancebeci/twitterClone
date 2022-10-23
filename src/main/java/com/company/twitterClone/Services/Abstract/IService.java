package com.company.twitterClone.Services.Abstract;

import java.util.List;

import com.company.twitterClone.Core.Utilities.Result.DataResult;

public interface IService<T> {
	DataResult<T> findOne(long id);

	DataResult<List<T>> findAll();

	DataResult<T> update(long id);

	DataResult<T> delete(long id);
}
