package com.example.Artilce.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Artilce.model.Comment;
import com.example.Artilce.service.CommentService;

public class CommentController {

	@Autowired
	private CommentService service;
	@PostMapping("/comment")
	public Comment addComment(@RequestParam("cid") int cid,@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("comment") String comment) throws IOException
	{
		Comment cmt=new Comment(cid,aid,uid,comment);
		return service.addComment(cmt);
	}
}
