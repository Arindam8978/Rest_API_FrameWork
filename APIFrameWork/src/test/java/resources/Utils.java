package resources;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	 public static RequestSpecification req;  // if we declare any variable as static means it'll share the single instance entire your execution.
	 											// it will share across all the test cases in that particular execution 
	 											// if we don't put static then it'll again start from initial variable what we declare. like, null, 0.
	 											//do not create one more instance 
	 						
	 
		/*
		 * public static RequestSpecification req; public RequestSpecification
		 * requestSpecification() throws IOException {
		 * 
		 * if(req==null) { PrintStream log =new PrintStream(new
		 * FileOutputStream("logging.txt")); req=new
		 * RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam(
		 * "key", "qaclick123") .addFilter(RequestLoggingFilter.logRequestTo(log))
		 * .addFilter(ResponseLoggingFilter.logResponseTo(log))
		 * .setContentType(ContentType.JSON).build(); return req; } return req;
		 * 
		 * 
		 * 
		 * 
		 * }
		 */
	  
	  
	  public static String getGlobalValue(String key) throws IOException {
		  Properties prop =new Properties(); 
		  FileInputStream fis =new FileInputStream("C:\\API_Rest_Assured_FrameWork\\APIFrameWork\\src\\test\\java\\resources\\global.properties");
		  prop.load(fis); 
		  return prop.getProperty(key);	  
	  }
	  
	  
		/*
		 * public String getJsonPath(Response response,String key) { String
		 * resp=response.asString(); JsonPath js = new JsonPath(resp); return
		 * js.get(key).toString(); }
		 */
	 
	
	
	public RequestSpecification RequestSpecification() throws IOException {
		
		
		if(req==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt")); 
		  req =new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
				  .addFilter(RequestLoggingFilter.logRequestTo(log))
				  .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		  
		  return req;
		}
		return req;		 		 		 
	}
	
	
	public String getJsonPath(Response response,String key)
	{
		  String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}
	
}
