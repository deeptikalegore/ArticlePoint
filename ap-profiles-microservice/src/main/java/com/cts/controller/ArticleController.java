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
import org.springframework.web.multipart.MultipartFile;

import com.cts.feign.ArtilceFeign;
import com.cts.model.Article;

@RestController
@RequestMapping(value="/portal")
public class ArticleController {
	
	@Autowired
	private ArtilceFeign artilceFeign;
	
	@GetMapping("/articles")
	public List<Article> getArticle(){
		return artilceFeign.getArticle();
	}
	@GetMapping("/articles/{id}")
	public Article getById(@PathVariable int id) {
		return artilceFeign.getById(id);
	}
	
	@PutMapping("/updatearticle")
	public Article updateArticle(@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("title") String title,
			@RequestParam("type") String type,@RequestParam("content") String content,@RequestParam("image") MultipartFile image) throws IOException
	{
		
		return artilceFeign.updateArticle(aid,uid,title,type,content,image);
	}
	
	@PostMapping("/postarticle")
	public Article addArticle(@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("title") String title,
			@RequestParam("type") String type,@RequestParam("content") String content,@RequestParam("image") MultipartFile image) throws IOException
	{
		
		return artilceFeign.addArticle(aid,uid,title,type,content,image);
	}
	

	
	@DeleteMapping("/article/{id}")
	public Article deleteArticle(@PathVariable int id) {
		return artilceFeign.deleteArticle(id);
	}
	
}
