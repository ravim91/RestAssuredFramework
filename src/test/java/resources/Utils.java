package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
     
	public static RequestSpecification reqSpec;
	
	public RequestSpecification requestSpecification() throws IOException
	
	{
		
		if (reqSpec==null)
		{
		 PrintStream log = new PrintStream(new FileOutputStream("loggging.txt"));
		 reqSpec =new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				 .addQueryParam("key","qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .build();
		 return reqSpec;
		}
		return reqSpec;
	}
	
	public static String getGlobalValue(String key) throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/ravikantmishra/Documents/Automating_API/src/test/java/resources/global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
		
		
		
	}
	
	public String getJsonPath(Response response, String key)
	{
		 String res = response.asString();
		    JsonPath js = new JsonPath(res);
		    return js.get(key).toString();
		
	}
}
