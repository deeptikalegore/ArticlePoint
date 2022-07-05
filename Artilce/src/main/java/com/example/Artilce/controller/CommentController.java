package com.example.Artilce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Artilce.model.Comment;
import com.example.Artilce.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService service;
	
	@GetMapping
	public List<Comment> getAll(){
		List<Comment> list=service.getAllComment();
		return list;
	}
	
	@GetMapping("/{aid}")
	public List<Comment> getAllByAid(@PathVariable int aid){
		List<Comment> list=service.getAllCommentByAid(aid);
		return list;
	}
	
	@GetMapping("/user/{uid}")
	public List<Comment> getAllByUid(@PathVariable int uid){
		List<Comment> list=service.getAllCommentByUid(uid);
		return list;
	}
	
	@PostMapping
	public Comment addComment(@RequestParam("cid") int cid,@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("comment") String comment)
	{
		Comment cmt=new Comment(cid,aid,uid,comment);
		return service.addComment(cmt);
	}
	
	@PutMapping
	public Comment updateComment(@RequestParam("cid") int cid,@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("comment") String comment) throws IOException
	{
		Comment cmt=new Comment(cid,aid,uid,comment);
		return service.updateComment(cmt);
	}
	
	@DeleteMapping
	public String deleteComment(@RequestParam("cid") int cid) {
		Comment cmt=service.getCommentById(cid);
		service.deleteComment(cid);
		return "comment deleted!";
	}
}