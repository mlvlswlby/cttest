package com.subrutin.com.quarkus;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.subrutin.com.dao.TagDao;
import com.subrutin.com.dao.impl.TagDaoImpl;
import com.subrutin.com.model.Tag;

import io.agroal.api.AgroalDataSource;

@Path("/cttest/tag")
public class CTTagResource {

	@Inject
	AgroalDataSource dataSource;
	
	TagDao tagDao = new TagDaoImpl();
	
	
    @GET
    @Path("/selectAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String selectAll() {
    	String response = new Gson().toJson(tagDao.selectAll(dataSource));
    	return response;
    }
    
    @GET
    @Path("/selectRow")
    @Produces(MediaType.APPLICATION_JSON)
    public String selectRow(@QueryParam("param") String param) {
    	String response = new Gson().toJson(tagDao.selectRowByParam(dataSource, param));
    	return response;
    }
    
    @GET
    @Path("/selectData")
    @Produces(MediaType.APPLICATION_JSON)
    public String selectData(@QueryParam("param") String param) {
    	String response = new Gson().toJson(tagDao.selectData(dataSource, param));
    	return response;
    }
    
    @POST
    @Path("/updateData")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateData(@FormParam("param") String param, @FormParam("param2") String param2) {
    	try {
    		System.out.println(param + " - " + param2);
    		tagDao.updateData(dataSource, param, param2);
    		return "SUCCESS";
    	}
    	catch(Exception e) {
    		return "FAILED";
    	}
    }
    
    @POST
    @Path("/deleteData")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteData(@FormParam("param") String param) {
    	try {
    		System.out.println(param);
    		tagDao.deleteData(dataSource, param);
    		return "SUCCESS";
    	}
    	catch(Exception e) {
    		return "FAILED";
    	}
    }
    
    @POST
    @Path("/insertData")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertData(@RequestParam String param) {
    	try {
    		System.out.println(param);
    		Gson g = new Gson();
    		Tag tag = g.fromJson(param, Tag.class);
    		tagDao.insertData(dataSource, tag);
    		return Response.status(Status.ACCEPTED).build();
    	}
    	catch(Exception e) {
    		return Response.status(Status.BAD_GATEWAY).build();
    	}
    }
    
    @POST
    @Path("/insertDatas")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertDatas(@RequestParam String param) {
    	try {
    		System.out.println(param);
    		Gson g = new Gson();
    		Type tagListType = new TypeToken<ArrayList<Tag>>(){}.getType();
    		ArrayList<Tag> tag = g.fromJson(param, tagListType);
    		tagDao.insertDatas(dataSource, tag);
    		return Response.status(Status.ACCEPTED).build();
    	}
    	catch(Exception e) {
    		return Response.status(Status.BAD_GATEWAY).build();
    	}
    }
	
}
