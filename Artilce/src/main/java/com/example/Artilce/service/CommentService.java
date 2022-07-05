package com.example.Artilce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Artilce.model.Article;
import com.example.Artilce.model.Comment;
import com.example.Artilce.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository repo;

	public List<Comment> getAllComment() {
		List<Comment> list = repo.findAll();
		return list;
	}
	
	public List<Comment> getAllCommentByAid(int aid) {
		List<Comment> list = repo.findByAid(aid);
		return list;
	}

	public List<Comment> getAllCommentByUid(int uid) {
		List<Comment> list = repo.findByUid(uid);
		return list;
	}
	
	public Comment getCommentById(int id) {
		Optional<Comment> op = repo.findById(id);
		if(!op.isPresent()) {
			throw new RuntimeException("Comment with id " + id+ " not exist!");
		}
		return op.get();
	}

	public Comment addComment(Comment cmt) {
		return repo.save(cmt);
	}

	public Comment updateComment(Comment cmt) {
		Optional<Comment> op = repo.findById(cmt.getCid());
		if (!op.isPresent()) {
			throw new RuntimeException("Comment with id " + cmt.getCid() + " not exist!");
		}
		Comment prevcmt = op.get();
		if (cmt.getComment() != null) {
			prevcmt.setComment(cmt.getComment());
		}
		repo.saveAndFlush(prevcmt);
		return prevcmt;
	}

	public void deleteComment(int id) {
		Comment cmt = repo.findById(id).get();
		repo.delete(cmt);
	}

}
