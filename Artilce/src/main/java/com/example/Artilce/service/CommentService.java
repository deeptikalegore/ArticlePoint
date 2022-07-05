package com.example.Artilce.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Artilce.repository.CommentRepository;
import com.example.Artilce.model.Comment;
public class CommentService {

	@Autowired
	private CommentRepository repo;
	
	public Comment addComment(Comment cmt) {
		repo.save(cmt);
		return cmt;
	}
}
