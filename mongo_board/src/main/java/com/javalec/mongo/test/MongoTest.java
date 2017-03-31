package com.javalec.mongo.test;

import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoTest {
	private MongoTemplate mongoTemplate;
	public MongoTest(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoTest mongoTest = new MongoTest();
		System.out.println(mongoTest.mongoTemplate);
	}

}
