package com.company.twitterClone.Services.Abstract;

import java.util.List;

import com.company.twitterClone.Core.Utilities.Result.DataResult;

public interface IService<T> {
	DataResult<T> findOne(Long id) throws Exception;

	DataResult<List<T>> findAll();

	DataResult<T> update(Long id);

	DataResult<T> delete(Long id);
}
