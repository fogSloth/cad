package com.dedalow.request;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import com.aventstack.extentreports.Status;
import java.io.IOException;
import com.dedalow.utils.Utils;
        import com.dedalow.report.Report;
 
public class post {
    private static String contentType = "application/json";
    public static FileSystem fileSystem = FileSystems.getDefault();
    private static String separator = fileSystem.getSeparator();
    public String jsonBody = "";

    private static String URL = "https://reqres.in/api/users";

    private static String post = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "post.json";
	private static String post1 = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "post1.json";
	private static String post2 = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "post2.json";
	private static String post3 = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "post3.json";
	
    public Response postPOST () throws IOException {
		jsonBody = Utils.generateJSONBody(post); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .post(URL);
        return response;
    }

    public Response postPOST1 () throws IOException {
		jsonBody = Utils.generateJSONBody(post1); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .post(URL);
        return response;
    }

    public Response postPOST2 () throws IOException {
		jsonBody = Utils.generateJSONBody(post2); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .post(URL);
        return response;
    }

    public Response postPOST3 () throws IOException {
		jsonBody = Utils.generateJSONBody(post3); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .post(URL);
        return response;
    }

    
}