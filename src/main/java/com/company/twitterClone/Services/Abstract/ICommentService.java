package com.company.twitterClone.Services.Abstract;

import java.util.List;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Concrete.Comment;

public interface ICommentService<CommentDto> extends IService<CommentDto> {
	Result createComment(Comment comment) throws Exception;
	List<CommentDto> findAllCommentsByUser(long id) throws Exception;
	List<CommentDto> findAllCommentsByTweet(long id) throws Exception;
	
}
