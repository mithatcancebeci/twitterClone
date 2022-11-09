package com.company.twitterClone.Services.Abstract;

import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Models.Concrete.Comment;

public interface ICommentService<CommentDto> extends IService<CommentDto> {
	Result createComment(Comment comment);
}
