package com.subrutin.com.dao;

import java.util.ArrayList;
import java.util.List;

import com.subrutin.com.model.Post;

import io.agroal.api.AgroalDataSource;

public interface PostDao {
	
	public List<Post> selectAll(AgroalDataSource ds);
	
	public Post selectRowByParam(AgroalDataSource ds, String param);
	
	public String selectData(AgroalDataSource ds, String param);
	
	public void updateData(AgroalDataSource ds, String param, String param2);
	
	public void deleteData(AgroalDataSource ds, String param);
	
	public void insertData(AgroalDataSource ds, Post param);
	
	public void insertDatas(AgroalDataSource ds, ArrayList<Post> param);
	
}
