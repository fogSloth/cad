package com.dedalow.request;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import com.aventstack.extentreports.Status;
import java.io.IOException;
import com.dedalow.utils.Utils;
        import com.dedalow.report.Report;
 
public class postError {
    private static String contentType = "application/json";
    public static FileSystem fileSystem = FileSystems.getDefault();
    private static String separator = fileSystem.getSeparator();
    public String jsonBody = "";

    private static String URL = "https://reqres.in";

    private static String postError = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "postError.json";
	private static String postError1 = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "postError1.json";
	private static String postError2 = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "postError2.json";
	private static String postError3 = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "postError3.json";
	
    public Response postErrorPOST () throws IOException {
        String queryParam = "/api/users";
		jsonBody = Utils.generateJSONBody(postError); 
        Response response = given()
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .post(URL + queryParam);
        return response;
    }

    public Response postErrorPOST1 () throws IOException {
        String queryParam = "/api/users";
		jsonBody = Utils.generateJSONBody(postError1); 
        Response response = given()
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .post(URL + queryParam);
        return response;
    }

    public Response postErrorPOST2 () throws IOException {
        String queryParam = "/api/users";
		jsonBody = Utils.generateJSONBody(postError2); 
        Response response = given()
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .post(URL + queryParam);
        return response;
    }

    public Response postErrorPOST3 () throws IOException {
        String queryParam = "/api/users";
		jsonBody = Utils.generateJSONBody(postError3); 
        Response response = given()
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .post(URL + queryParam);
        return response;
    }

    
}