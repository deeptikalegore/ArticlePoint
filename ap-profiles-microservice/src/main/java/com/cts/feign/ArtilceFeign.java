package com.cts.feign;

import java.io.IOException;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cts.model.Article;
import com.cts.model.Comment;

@FeignClient(name = "Artilce", url = "${artilce.URL}")
public interface ArtilceFeign {
		
	@GetMapping("/articles")
	public List<Article> getArticle();
	
	@GetMapping("/articles/{id}")
	public Article getById(@PathVariable int id);
	
	@PutMapping("/updatearticle")
	public Article updateArticle(@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("title") String title,
			@RequestParam("type") String type,@RequestParam("content") String content,@RequestParam("image") MultipartFile image) throws IOException;
	
	@PostMapping("/postarticle")
	public Article addArticle(@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("title") String title,
			@RequestParam("type") String type,@RequestParam("content") String content,@RequestParam("image") MultipartFile image) throws IOException;
	
	@DeleteMapping("/article/{id}")
	public Article deleteArticle(@PathVariable int id);
	
	@GetMapping("/comments")
	public List<Comment> getAll();
	
	@GetMapping("/comments/{aid}")
	public List<Comment> getAllByAid(@PathVariable int aid);

	@GetMapping("/usercomment/{uid}")
	public List<Comment> getAllByUid(@PathVariable int uid);
	
	@PostMapping("/postcomment")
	public Comment addComment(@RequestParam("cid") int cid,@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("comment") String comment);
	
	@PutMapping("/updatecomment")
	public Comment updateComment(@RequestParam("cid") int cid,@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("comment") String comment) throws IOException;
	
	@DeleteMapping("/deletecomment/{cid}")
	public String deleteComment(@RequestParam("cid") int cid); 
	
	@GetMapping("/comment/{id}")
	public Comment getByCommId(@PathVariable int id);
	
	
}
