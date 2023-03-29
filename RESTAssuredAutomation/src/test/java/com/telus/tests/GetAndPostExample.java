package com.telus.tests;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExample {
	
	@Test
	public void testGet() {
		//https://reqres.in/api/users?page=2
		baseURI= "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name" , equalTo("George"));
	}
	
	@Test
	public void testPost() {
		
		Map<String,Object> map =new HashMap<String,Object>();
/*		map.put("name", "Marry");
		map.put("job", "QA");
		System.out.println(map); //Output={name=Marry, job=QA} not in JSON format

		JSONObject request= new JSONObject(map); //need to add dependency
			
		System.out.println(request); //Output={"name":"Marry","job":"QA"}
		
		System.out.println(request.toJSONString());//Validate the is converting into JSON string OP={"name":"Marry","job":"QA"}
*/
		JSONObject request= new JSONObject();
		request.put("name", "Marry");
		request.put("job", "QA");
		System.out.println(request.toJSONString()); //Output={"name":"Marry","job":"QA"}
		
		baseURI= "https://reqres.in/api";
		
		given().
			header("Content-Type","applicatio/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
		
		}

}
