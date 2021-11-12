package com.subrutin.com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.subrutin.com.dao.TagDao;
import com.subrutin.com.model.Tag;

import io.agroal.api.AgroalDataSource;

public class TagDaoImpl implements TagDao {

	public List<Tag> selectAll(AgroalDataSource dataSource){
		List<Tag> lTag = new ArrayList<>();
		
		try {
			Connection conn = dataSource.getConnection();
			Statement stat = conn.createStatement();
	    	ResultSet rs = stat.executeQuery("SELECT * FROM testct.tag");
	    	
	    	while (rs.next()) {
	    		Tag mTag = new Tag();
	    		mTag.setId(rs.getLong("id"));
	    		mTag.setLabel(rs.getString("label"));
	    		mTag.setPosts(rs.getLong("posts"));
	    		lTag.add(mTag);
	    	}
	    	
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		return lTag;
	}
	
	public Tag selectRowByParam(AgroalDataSource dataSource, String param) {
		Tag mTag = new Tag();
		
		try {
			Connection conn = dataSource.getConnection();
			Statement stat = conn.createStatement();
	    	ResultSet rs = stat.executeQuery("SELECT * FROM testct.tag WHERE id = " + param + "");
	    	
	    	while (rs.next()) {
	    		mTag.setId(rs.getLong("id"));
	    		mTag.setLabel(rs.getString("label"));
	    		mTag.setPosts(rs.getLong("posts"));
	    	}
	    	
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mTag;
	}
	
	public String selectData(AgroalDataSource ds, String param) {
		String result = "";
		try {
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
	    	ResultSet rs = stat.executeQuery("SELECT id FROM testct.tag WHERE label = '" + param + "'");
	    	
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
	    	stat.executeUpdate("UPDATE testct.tag SET label = '" + param + "'" + "WHERE id = " + param2);
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteData(AgroalDataSource ds, String param) {
		try {
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
	    	stat.executeUpdate("DELETE FROM testct.tag WHERE id = " + param);
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertData(AgroalDataSource ds, Tag param) {
		try {
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
	    	stat.executeUpdate("INSERT INTO testct.tag (label,posts) VALUES "
	    			+ "('" + param.getLabel() + "','" + param.getPosts() + "')");
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertDatas(AgroalDataSource ds, ArrayList<Tag> param) {
		try {
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
			
			for (int i=0; i<param.size(); i++) {
		    	stat.executeUpdate("INSERT INTO testct.tag (label,posts) VALUES "
    			+ "('" + param.get(i).getLabel() + "','" + param.get(i).getPosts() + "')");
			}
			
	    	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
