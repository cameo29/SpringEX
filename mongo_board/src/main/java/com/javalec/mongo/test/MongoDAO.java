package com.javalec.mongo.test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoDAO {
	private MongoTemplate mongoTemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public void insertTestVO(){
		TestVO testVO = new TestVO();
		testVO.setbId(3);
		testVO.setbName("yang");
		testVO.setbTitle("datamongo");
		testVO.setbContent("success");
		
		mongoTemplate.insert(testVO,"Member");
	}
	
	public class TestVO{
		@Id
		private int bId;
		private String bName;
		
		private String bTitle;
		private String bContent;
		public int getbId() {
			return bId;
		}
		public void setbId(int bId) {
			this.bId = bId;
		}
		public String getbName() {
			return bName;
		}
		public void setbName(String bName) {
			this.bName = bName;
		}
		public String getbTitle() {
			return bTitle;
		}
		public void setbTitle(String bTitle) {
			this.bTitle = bTitle;
		}
		public String getbContent() {
			return bContent;
		}
		public void setbContent(String bContent) {
			this.bContent = bContent;
		}
		
		
		
	}
}
