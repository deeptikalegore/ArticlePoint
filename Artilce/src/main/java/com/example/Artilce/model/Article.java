package com.example.Artilce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Article {

	@Id
	private int aid;
	private String username;
	private String title;
	private String type;
	private String content;
	private String image;
	
	
	public Article() {
		
	}
	public Article(int aid, String username, String title, String type,  String content, String image) {
		super();
		this.aid = aid;
		this.username = username;
		this.title = title;
		this.type = type;
		this.content = content;
		this.image=image;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}
