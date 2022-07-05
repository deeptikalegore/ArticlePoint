package com.example.Artilce.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Artilce.model.Article;
import com.example.Artilce.service.ArticleService;

@RestController
@RequestMapping(value="/articles")
public class ArticleController {

	@Autowired
	private ArticleService service;
	@GetMapping
	public List<Article> getArticle(){
		return service.getArticle();
	}
	@GetMapping("/{id}")
	public Article getById(@PathVariable int id) {
		return service.getArticleById(id);
	}
	
	@PutMapping
	public Article updateArticle(@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("title") String title,
			@RequestParam("type") String type,@RequestParam("content") String content,@RequestParam("image") MultipartFile image) throws IOException
	{
		
		return service.updateArticle(aid,uid,title,type,content,image);
	}
	
	@PostMapping
	public Article addArticle(@RequestParam("aid") int aid,@RequestParam("uid") int uid,@RequestParam("title") String title,
			@RequestParam("type") String type,@RequestParam("content") String content,@RequestParam("image") MultipartFile image) throws IOException
	{
		
		return service.addArticle(aid,uid,title,type,content,image);
	}
	

	
	@DeleteMapping("/{id}")
	public Article deleteArticle(@PathVariable int id) {
		return service.deleteArticle(id);
	}
	
}
