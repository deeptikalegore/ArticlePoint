package com.example.Artilce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Artilce.model.Comment;


public interface CommentRepository extends JpaRepository<Comment, Integer> {

	 List<Comment> findByUid(int uid);
	 
	 List<Comment> findByAid(int aid);
}
