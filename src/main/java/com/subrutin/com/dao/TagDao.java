package com.subrutin.com.dao;

import java.util.ArrayList;
import java.util.List;

import com.subrutin.com.model.Tag;

import io.agroal.api.AgroalDataSource;

public interface TagDao {

	public List<Tag> selectAll(AgroalDataSource ds);
	
	public Tag selectRowByParam(AgroalDataSource ds, String param);
	
	public String selectData(AgroalDataSource ds, String param);
	
	public void updateData(AgroalDataSource ds, String param, String param2);
	
	public void deleteData(AgroalDataSource ds, String param);
	
	public void insertData(AgroalDataSource ds, Tag param);
	
	public void insertDatas(AgroalDataSource ds, ArrayList<Tag> param);
	
}
