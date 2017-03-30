package com.javalec.ex.dao;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.javalec.ex.dto.BDto;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class BDao {
	
	public BDto contentView(int strID){

		BDto dto = null;

		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
		
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("springex");
		DBCollection collection = db.getCollection("mvc_board");
		BasicDBObject query = new BasicDBObject();
		query.put("bId", strID);
		
		DBCursor cursor = collection.find(query);
		
		try{
			while(cursor.hasNext()){
				DBObject map = cursor.next();
				int bHit = 0;
				int bGroup = 0;
				int bStep = 0;
				int bIndent = 0;
				
				int bId = ((Number)map.get("bId")).intValue();
				String bName = map.get("bName").toString();
				String bTitle = map.get("bTitle").toString();
				String bContent = map.get("bContent").toString();
				
				if(map.get("bHit") != null) bHit =((Number)map.get("bHit")).intValue();
				if(map.get("bGroup") != null) bGroup =((Number)map.get("bGroup")).intValue();
				if(map.get("bStep") != null) bStep =((Number)map.get("bStep")).intValue();
				if(map.get("bIndent") != null) bIndent =((Number)map.get("bIndent")).intValue();

				dto = new BDto(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent);
			}
						
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			cursor.close();
		}
		
		return dto;
	}
	
	public void write(String bName, String bTitle, String bContent){
		
		try{
			MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
			
			@SuppressWarnings("deprecation")
			DB db = mongoClient.getDB("springex");
			DBCollection collection = db.getCollection("mvc_board");	
			
			System.out.println("connect to database!");
			
			BasicDBObject doc = new BasicDBObject().
					append("bId", 2).
					append("bName", bName).
		            append("bTitle", bTitle).
		            append("bContent", bContent);
						
			collection.insert(doc);
		    System.out.println("Document inserted successfully");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public BDao(){
		try {
			Context context = new InitialContext();
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		//db연결
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
		
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("springex");
		DBCollection collection = db.getCollection("mvc_board");
		DBCursor cursor = collection.find();
		
		try{
			while(cursor.hasNext()){
				DBObject map = cursor.next();
				
				int bHit = 0;
				int bGroup = 0;
				int bStep = 0;
				int bIndent = 0;
				
				int bId = ((Number)map.get("bId")).intValue();
				String bName = map.get("bName").toString();
				String bTitle = map.get("bTitle").toString();
				String bContent = map.get("bContent").toString();
				
				if(map.get("bHit") != null) bHit =((Number)map.get("bHit")).intValue();
				if(map.get("bGroup") != null) bGroup =((Number)map.get("bGroup")).intValue();
				if(map.get("bStep") != null) bStep =((Number)map.get("bStep")).intValue();
				if(map.get("bIndent") != null) bIndent =((Number)map.get("bIndent")).intValue();
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
				
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			cursor.close();
		}
		return dtos;
	}
}
