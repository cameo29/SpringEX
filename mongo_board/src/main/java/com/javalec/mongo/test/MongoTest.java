package com.javalec.mongo.test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MongoTest {

	public static void main(String[] args) {
		String url = "mongoContext.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(url);
		MongoDAO dao = ctx.getBean("mongoDAO", MongoDAO.class);
		
		if(dao == null){
		    System.out.println("NULL!!!");
		}
		else {
		    System.out.println("NOT NULL!!");
		    dao.insertTestVO();
		}


	}

}
