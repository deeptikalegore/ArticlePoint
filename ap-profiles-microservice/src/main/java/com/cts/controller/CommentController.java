package com.cts.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.feign.ArtilceFeign;
import com.cts.model.Comment;

@RestController
@RequestMapping(value="/portal")
public class CommentController {
	
	@Autowired
	private ArtilceFeign artilceFeign;
	
	@GetMapping("/comments")
	public List<Comment> getAll(){
		List<Comment> list=artilceFeign.getAll();
		return list;
	}
	
	@GetMapping("/comments/{aid}")
	public List<Comment> getAllByAid(@PathVariable int aid){
		List<Comment> list=artilceFeign.getAllByAid(aid);
		return list;
	}
	
	@GetMapping("/comment/{id}")
	public Comment getByCommId(@PathVariable int id) {
		return artilceFeign.getByCommId(id);
	}
	
	@GetMapping("/usercomment/{uid}")
	public List<Comment> getAllByUid(@PathVariable int uid){
		List<Comment> list=artilceFeign.getAllByUid(uid);
		return list;
	}
	
	@PostMapping("/postcomment")
	public Comment addComment(@RequestParam("cid") int cid,@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("comment") String comment)
	{
		Comment cmt=new Comment(cid,aid,uid,comment);
		return artilceFeign.addComment(cid, aid, uid, comment);
	}
	
	@PutMapping("/updatecomment")
	public Comment updateComment(@RequestParam("cid") int cid,@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("comment") String comment) throws IOException
	{
		Comment cmt=new Comment(cid,aid,uid,comment);
		return artilceFeign.updateComment(cid, aid, uid, comment);
	}
	
	@DeleteMapping("/deletecomment/{cid}")
	public String deleteComment(@RequestParam("cid") int cid) {
		Comment cmt=artilceFeign.getByCommId(cid);
		artilceFeign.deleteComment(cid);
		return "comment deleted!";
	}
	
}
