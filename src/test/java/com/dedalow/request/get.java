package com.dedalow.request;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import com.aventstack.extentreports.Status;
import java.io.IOException;
import com.dedalow.utils.Utils;
        import com.dedalow.report.Report;
 
public class get {
    private static String contentType = "application/json";
    public static FileSystem fileSystem = FileSystems.getDefault();
    private static String separator = fileSystem.getSeparator();
    public String jsonBody = "";

    private static String URL = "https://reqres.in/api/users";

    
    public Response getGET () throws IOException {
        String queryParam = "page/2";
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
            .when()
            .get(URL + queryParam);
        return response;
    }

    public Response getGET1 () throws IOException {
        String queryParam = "page/2";
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
            .when()
            .get(URL + queryParam);
        return response;
    }

    public Response getGET2 () throws IOException {
        String queryParam = "page/2";
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
            .when()
            .get(URL + queryParam);
        return response;
    }

    public Response getGET3 () throws IOException {
        String queryParam = "page/2";
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
            .when()
            .get(URL + queryParam);
        return response;
    }

    
}