package com.example.Artilce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Artilce.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer>  {

}
