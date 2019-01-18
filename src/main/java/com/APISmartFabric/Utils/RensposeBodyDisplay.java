package com.APISmartFabric.Utils;

import javax.xml.ws.Response;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.response.ResponseOptions;
import com.jayway.restassured.specification.RequestSpecification;

public class RensposeBodyDisplay {
	
	
	public String response() {
	RequestSpecification httpRequest = RestAssured.given();
	Response response = (Response) httpRequest.get("/users");
	ResponseBody body = ((ResponseOptions<com.jayway.restassured.response.Response>) response).getBody();
//	System.out.println("Response Body is: " + body.asString());
	return body.asString();
	}
}
