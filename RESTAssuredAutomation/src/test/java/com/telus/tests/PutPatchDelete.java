package com.telus.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class PutPatchDelete {

	@Test
	public void testPost() {
		JSONObject request= new JSONObject();

		request.put("name", "Marry");
		request.put("job", "QA");

		System.out.println(request.toJSONString());

		baseURI= "https://reqres.in/api";

		given().
		header("Content-Type","applicatio/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/users/2").
		then().
		statusCode(200).log().all();

	}

	@Test
	public void testPatch() {
		JSONObject request= new JSONObject();

		request.put("name", "Marry");
		request.put("job", "QA");

		System.out.println(request.toJSONString());

		baseURI= "https://reqres.in";

		given().
		header("Content-Type","applicatio/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/api/users/2").
		then().
		statusCode(200).log().all();
	}

	@Test
	public void testDelete() {
		
		baseURI= "https://reqres.in";

		when().
		delete("/api/users/2").
		then().
		statusCode(204).log().all();
	}


}
