package com.subrutin.com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.subrutin.com.dao.PostDao;
import com.subrutin.com.model.Post;

import io.agroal.api.AgroalDataSource;

public class PostDaoImpl implements PostDao{

	public List<Post> selectAll(AgroalDataSource dataSource){
		List<Post> lPost = new ArrayList<>();
		
		try {
			Connection conn = dataSource.getConnection();
			Statement stat = conn.createStatement();
	    	ResultSet rs = stat.executeQuery("SELECT * FROM testct.post");
	    	
	    	while (rs.next()) {
	    		Post mPost = new Post();
	    		mPost.setId(rs.getLong("id"));
	    		mPost.setTitle(rs.getString("title"));
	    		mPost.setContent(rs.getString("content"));
	    		mPost.setTags(rs.getLong("tags"));
	    		lPost.add(mPost);
	    	}
	    	
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		return lPost;
	}
	
	public Post selectRowByParam(AgroalDataSource dataSource, String param) {
		Post mPost = new Post();
		
		try {
			Connection conn = dataSource.getConnection();
			Statement stat = conn.createStatement();
	    	ResultSet rs = stat.executeQuery("SELECT * FROM testct.post WHERE title = '" + param + "'");
	    	
	    	while (rs.next()) {
	    		mPost.setId(rs.getLong("id"));
	    		mPost.setTitle(rs.getString("title"));
	    		mPost.setContent(rs.getString("content"));
	    		mPost.setTags(rs.getLong("tags"));
	    	}
	    	
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mPost;
	}
	
	public String selectData(AgroalDataSource ds, String param) {
		String result = "";
		try {
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
	    	ResultSet rs = stat.executeQuery("SELECT id FROM testct.post WHERE title = '" + param + "'");
	    	
	    	while (rs.next()) {
	    		result = String.valueOf(rs.getLong("id"));
	    	}
	    	
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void updateData(AgroalDataSource ds, String param, String param2) {
		try {
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
	    	stat.executeUpdate("UPDATE testct.post SET content = '" + param + "'" + "WHERE id = " + param2);
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteData(AgroalDataSource ds, String param) {
		try {
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
	    	stat.executeUpdate("DELETE FROM testct.post WHERE id = " + param);
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertData(AgroalDataSource ds, Post param) {
		try {
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
	    	stat.executeUpdate("INSERT INTO testct.post (title,content,tags) VALUES "
	    			+ "('" + param.getTitle() + "','" + param.getContent() + "','" + param.getTags() + "')");
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertDatas(AgroalDataSource ds, ArrayList<Post> param) {
		try {
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
			
			for (int i=0; i<param.size(); i++) {
		    	stat.executeUpdate("INSERT INTO testct.post (title,content,tags) VALUES "
    			+ "('" + param.get(i).getTitle() + "','" + param.get(i).getContent() + "','" + param.get(i).getTags() + "')");
			}
			
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
