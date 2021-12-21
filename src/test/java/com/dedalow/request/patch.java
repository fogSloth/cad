package com.dedalow.request;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import com.aventstack.extentreports.Status;
import java.io.IOException;
import com.dedalow.utils.Utils;
        import com.dedalow.report.Report;
 
public class patch {
    private static String contentType = "application/json";
    public static FileSystem fileSystem = FileSystems.getDefault();
    private static String separator = fileSystem.getSeparator();
    public String jsonBody = "";

    private static String URL = "https://reqres.in/api/";

    private static String patch = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "patch.json";
	private static String patch1 = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "patch1.json";
	private static String patch2 = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "patch2.json";
	private static String patch3 = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "patch3.json";
	
    public Response patchPATCH () throws IOException {
        String queryParam = "users/2";
		jsonBody = Utils.generateJSONBody(patch); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .patch(URL + queryParam);
        return response;
    }

    public Response patchPATCH1 () throws IOException {
        String queryParam = "users/2";
		jsonBody = Utils.generateJSONBody(patch1); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .patch(URL + queryParam);
        return response;
    }

    public Response patchPATCH2 () throws IOException {
        String queryParam = "users/2";
		jsonBody = Utils.generateJSONBody(patch2); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .patch(URL + queryParam);
        return response;
    }

    public Response patchPATCH3 () throws IOException {
        String queryParam = "users/2";
		jsonBody = Utils.generateJSONBody(patch3); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .patch(URL + queryParam);
        return response;
    }

    
}