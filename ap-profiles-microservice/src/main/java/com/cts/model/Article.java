package com.cts.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Article {

	
	private int aid;
	private int uid;
	private String title;
	private String type;
	private String content;
	private String image;
	private int likes=0;
	private Date date;
	
	
	
	
	public Article() {
		
	}
	public Article(int aid, int uid , String title, String type,  String content, String image,Date date) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.title = title;
		this.type = type;
		this.content = content;
		this.image=image;
		this.date=date;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	@Override
	public String toString() {
		return "Article [aid=" + aid + ", uid=" + uid + ", title=" + title + ", type=" + type + ", content=" + content
				+ ", image=" + image + ", date=" + date + "]";
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
}
