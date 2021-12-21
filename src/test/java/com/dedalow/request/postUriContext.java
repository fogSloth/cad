package com.dedalow.request;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import com.aventstack.extentreports.Status;
import java.io.IOException;
import com.dedalow.utils.Utils;
        import com.dedalow.report.Report;
 
public class postUriContext {
    private static String contentType = "application/json";
    public static FileSystem fileSystem = FileSystems.getDefault();
    private static String separator = fileSystem.getSeparator();
    public String jsonBody = "";

    private static String URL = Utils.prop.getProperty("BACKEND_ENDPOINT") + "/api/users";

    private static String postUriContext = System.getProperty("user.dir") + separator + "resources"
            + separator + "request" + separator + "postUriContext.json";
	
    public Response postUriContextPOST () throws IOException {
		jsonBody = Utils.generateJSONBody(postUriContext); 
        Response response = given()
			.header("Accept-Charset", "UTF-8")
            .contentType(contentType)
			.body(jsonBody)
            .when()
            .post(URL);
        return response;
    }

    
}