package com.example.Artilce.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment {

	@Id
	private int cid;
	private int aid;
	private int uid;
	private String comment;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int cid, int aid, int uid, String comment) {
		super();
		this.cid = cid;
		this.aid = aid;
		this.uid = uid;
		this.comment = comment;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", aid=" + aid + ", uid=" + uid + ", comment=" + comment + "]";
	}
}