package com.subrutin.com.model;

public class Post {
	
	private Long id;
	private String title;
	private String content;
	private Long tags;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Long getTags() {
		return tags;
	}
	public void setTags(Long tags) {
		this.tags = tags;
	}
	
}
