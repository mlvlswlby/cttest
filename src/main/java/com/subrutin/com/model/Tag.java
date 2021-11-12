package com.subrutin.com.model;

public class Tag {

	private Long id;
	private String label;
	private Long posts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Long getPosts() {
		return posts;
	}
	public void setPosts(Long posts) {
		this.posts = posts;
	}
	
}
