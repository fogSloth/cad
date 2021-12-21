package com.dedalow.request;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import com.aventstack.extentreports.Status;
import java.io.IOException;
import com.dedalow.utils.Utils;
        import com.dedalow.report.Report;
 
public class put {
    private static String contentType = "application/json";
    public static FileSystem fileSystem = FileSystems.getDefault();
    private static String separator = fileSystem.getSeparator();
    public String jsonBody = "";

    private static String URL = "https://reqres.in/api/";

    private static String put = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "put.json";
	private static String put1 = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "put1.json";
	private static String put2 = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "put2.json";
	private static String put3 = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "put3.json";
	
    public Response putPUT () throws IOException {
        String queryParam = "users/2";
		jsonBody = Utils.generateJSONBody(put); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .put(URL + queryParam);
        return response;
    }

    public Response putPUT1 () throws IOException {
        String queryParam = "users/2";
		jsonBody = Utils.generateJSONBody(put1); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .put(URL + queryParam);
        return response;
    }

    public Response putPUT2 () throws IOException {
        String queryParam = "users/2";
		jsonBody = Utils.generateJSONBody(put2); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .put(URL + queryParam);
        return response;
    }

    public Response putPUT3 () throws IOException {
        String queryParam = "users/2";
		jsonBody = Utils.generateJSONBody(put3); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .put(URL + queryParam);
        return response;
    }

    
}