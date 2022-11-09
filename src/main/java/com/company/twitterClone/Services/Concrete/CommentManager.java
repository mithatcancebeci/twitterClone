package com.company.twitterClone.Services.Concrete;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.twitterClone.Core.Utilities.Result.DataResult;
import com.company.twitterClone.Core.Utilities.Result.Result;
import com.company.twitterClone.Core.Utilities.Result.SuccessResultData;
import com.company.twitterClone.Models.Concrete.Comment;
import com.company.twitterClone.Models.Dtos.CommentDto;
import com.company.twitterClone.Models.Dtos.UserDto;
import com.company.twitterClone.Repository.CommentRepository;
import com.company.twitterClone.Services.Abstract.ICommentService;

@Service
public class CommentManager implements ICommentService<CommentDto> {
	CommentRepository commentRepository;

	public CommentManager(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public DataResult<CommentDto> findOne(long id) throws Exception {
		if (id <= 0) {
			throw new Exception("Comment was not found");
		}

		var commentInDB = commentRepository.findById(id);

		if (commentInDB == null) {
			throw new Exception("Comment was not found");
		}

		var comment = commentInDB.get();

		if (comment.getUser() == null) {
			throw new Exception("User not found");
		}

		CommentDto commentDto = new CommentDto();

		commentDto.setContent(comment.getContent());
		commentDto.setId(comment.getId());
		commentDto.setLikeCount(comment.getLikeCount());
		commentDto.setReTweetCount(commentDto.getLikeCount());
		commentDto.setUser(new UserDto(comment.getUser()));
		commentDto.setCreatedAt(comment.getCreatedAt());
		commentDto.setUpdatedAt(comment.getUpdatedAt());

		return new SuccessResultData<CommentDto>(commentDto);
	}

	@Override
	public DataResult<List<CommentDto>> findAll() {
		return null;
	}

	@Override
	public DataResult<CommentDto> update(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<CommentDto> delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result createComment(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}

}