package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;



import com.dedalow.request.postError;
	import com.dedalow.request.put;
	import com.dedalow.request.patch;
	import com.dedalow.request.get;
	import com.dedalow.request.postUriContext;
	import com.dedalow.request.post;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.restassured.response.Response;

public class A_BackendAction2Action {
    
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    private postError postError;
	private put put;
	private patch patch;
	private get get;
	private postUriContext postUriContext;
	private post post;
	
    
    
    
    
    public A_BackendAction2Action(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        postError = new postError();
	put = new put();
	patch = new patch();
	get = new get();
	postUriContext = new postUriContext();
	post = new post();
	
         
        
        
    }
    

public A_BackendAction2Action postPOST2() throws IOException {
          dependencies.isBackend = true;
          apiResponse = post.postPOST2();
    Report.reportLog(dependencies, "The field post2 completed", "INFO", 0, Status.PASS, false, "BackendInvoke postPOST2 <strong> POST </strong> completed "
    + "<br> <strong> Url: </strong>" + "https://reqres.in/api/users" + " </br>"+ "<strong> Request: </strong></br>"
    + "<textarea readonly>" + post.jsonBody + " </textarea>",
    "<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
          Report.reportLog(dependencies, "post action completed", "INFO", 0, Status.PASS, false, "", "", null);
          dependencies.isBackend = false;
          return this;
    }
    
    
public A_BackendAction2Action VerdictPost2() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(apiResponse.getHeader("Content-Type").contains("utf-8"),
            "Error assertion BackendAssertion12 check the Header return Content-Type: "
            + apiResponse.getHeader("Content-Type") + ", expected contains utf-8");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion12 check the Header return Content-Type: "  + apiResponse.getHeader("Content-Type")
            + ", expected contains utf-8", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion12 check the Header <br><strong>return</strong> Content-Type: "  + apiResponse.getHeader("Content-Type")
            + ",</br> <strong> expected </strong> contains utf-8", "backendAssertion", null);
            
            
            assertTrue(apiResponse.jsonPath().getString("job").contains("leader"),
            "Error assertion BackendAssertion13 check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected contains leader");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion13 check the Body return job: "  + apiResponse.jsonPath().getString("job")
            + ", expected contains leader", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion13 check the Body <br><strong>return</strong> job: "  + apiResponse.jsonPath().getString("job")
            + ",</br> <strong> expected </strong> contains leader", "backendAssertion", null);
            
            
        	assertTrue(201 == apiResponse.getStatusCode(),
        	"VerdictPost2 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 201");
        Report.reportLog(dependencies, "Correct assertion in VerdictPost2 returns "
        + apiResponse.getStatusCode() + " status code, expected 201", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPost2 <br><strong>returns</strong> "
        + apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 201", "backendAssertion", null);
        dependencies.isBackend = false;
        return this;  
    }
    
    
public A_BackendAction2Action getGET2() throws IOException {
          dependencies.isBackend = true;
          apiResponse = get.getGET2();
    Report.reportLog(dependencies, "The field get2 completed", "INFO", 0, Status.PASS, false, "BackendInvoke getGET2 <strong> GET </strong> completed "
    + "<br> <strong> Url: </strong>" + "https://reqres.in/api/users" + " </br>",
    "<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
          Report.reportLog(dependencies, "get action completed", "INFO", 0, Status.PASS, false, "", "", null);
          dependencies.isBackend = false;
          return this;
    }
    
    
public A_BackendAction2Action VerdictGet2() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(apiResponse.jsonPath().getString("support").contains("[text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]"),
            "Error assertion BackendAssertion14 check the Body return support: "
            + apiResponse.jsonPath().getString("support") + ", expected contains [text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion14 check the Body return support: "  + apiResponse.jsonPath().getString("support")
            + ", expected contains [text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion14 check the Body <br><strong>return</strong> support: "  + apiResponse.jsonPath().getString("support")
            + ",</br> <strong> expected </strong> contains [text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]", "backendAssertion", null);
            
            
        	assertTrue(200 == apiResponse.getStatusCode(),
        	"VerdictGet2 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 200");
        Report.reportLog(dependencies, "Correct assertion in VerdictGet2 returns "
        + apiResponse.getStatusCode() + " status code, expected 200", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictGet2 <br><strong>returns</strong> "
        + apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 200", "backendAssertion", null);
        dependencies.isBackend = false;
        return this;  
    }
    
    
public A_BackendAction2Action patchPATCH2() throws IOException {
          dependencies.isBackend = true;
          apiResponse = patch.patchPATCH2();
    Report.reportLog(dependencies, "The field patch2 completed", "INFO", 0, Status.PASS, false, "BackendInvoke patchPATCH2 <strong> PATCH </strong> completed "
    + "<br> <strong> Url: </strong>" + "https://reqres.in/api/" + " </br>"+ "<strong> Request: </strong></br>"
    + "<textarea readonly>" + patch.jsonBody + " </textarea>",
    "<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
          Report.reportLog(dependencies, "patch action completed", "INFO", 0, Status.PASS, false, "", "", null);
          dependencies.isBackend = false;
          return this;
    }
    
    
public A_BackendAction2Action VerdictPatch2() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(apiResponse.jsonPath().getString("updatedAt").contains("2021"),
            "Error assertion BackendAssertion11 check the Body return updatedAt: "
            + apiResponse.jsonPath().getString("updatedAt") + ", expected contains 2021");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion11 check the Body return updatedAt: "  + apiResponse.jsonPath().getString("updatedAt")
            + ", expected contains 2021", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion11 check the Body <br><strong>return</strong> updatedAt: "  + apiResponse.jsonPath().getString("updatedAt")
            + ",</br> <strong> expected </strong> contains 2021", "backendAssertion", null);
            
            
        	assertTrue(200 == apiResponse.getStatusCode(),
        	"VerdictPatch2 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 200");
        Report.reportLog(dependencies, "Correct assertion in VerdictPatch2 returns "
        + apiResponse.getStatusCode() + " status code, expected 200", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPatch2 <br><strong>returns</strong> "
        + apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 200", "backendAssertion", null);
        dependencies.isBackend = false;
        return this;  
    }
    
    
public A_BackendAction2Action putPUT2() throws IOException {
          dependencies.isBackend = true;
          apiResponse = put.putPUT2();
    Report.reportLog(dependencies, "The field put2 completed", "INFO", 0, Status.PASS, false, "BackendInvoke putPUT2 <strong> PUT </strong> completed "
    + "<br> <strong> Url: </strong>" + "https://reqres.in/api/" + " </br>"+ "<strong> Request: </strong></br>"
    + "<textarea readonly>" + put.jsonBody + " </textarea>",
    "<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
          Report.reportLog(dependencies, "put action completed", "INFO", 0, Status.PASS, false, "", "", null);
          dependencies.isBackend = false;
          return this;
    }
    
    
public A_BackendAction2Action VerdictPut2() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(!apiResponse.jsonPath().getString("job").contains("jesus"),
            "Error assertion BackendAssertion10 check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected notContains jesus");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion10 check the Body return job: "  + apiResponse.jsonPath().getString("job")
            + ", expected notContains jesus", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion10 check the Body <br><strong>return</strong> job: "  + apiResponse.jsonPath().getString("job")
            + ",</br> <strong> expected </strong> notContains jesus", "backendAssertion", null);
            
            
        	assertTrue(200 == apiResponse.getStatusCode(),
        	"VerdictPut2 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 200");
        Report.reportLog(dependencies, "Correct assertion in VerdictPut2 returns "
        + apiResponse.getStatusCode() + " status code, expected 200", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPut2 <br><strong>returns</strong> "
        + apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 200", "backendAssertion", null);
        dependencies.isBackend = false;
        return this;  
    }
    
    
public A_BackendAction2Action postErrorPOST2() throws IOException {
          dependencies.isBackend = true;
          apiResponse = postError.postErrorPOST2();
    Report.reportLog(dependencies, "The field postError2 completed", "INFO", 0, Status.PASS, false, "BackendInvoke postErrorPOST2 <strong> POST </strong> completed "
    + "<br> <strong> Url: </strong>" + "https://reqres.in" + " </br>"+ "<strong> Request: </strong></br>"
    + "<textarea readonly>" + postError.jsonBody + " </textarea>",
    "<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
          Report.reportLog(dependencies, "postError action completed", "INFO", 0, Status.PASS, false, "", "", null);
          dependencies.isBackend = false;
          return this;
    }
    
    
public A_BackendAction2Action VerdictPostError2() throws Exception {
        dependencies.isBackend = true;
        
        	assertTrue(201 == apiResponse.getStatusCode(),
        	"VerdictPostError2 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 201");
        Report.reportLog(dependencies, "Correct assertion in VerdictPostError2 returns "
        + apiResponse.getStatusCode() + " status code, expected 201", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPostError2 <br><strong>returns</strong> "
        + apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 201", "backendAssertion", null);
        dependencies.isBackend = false;
        return this;  
    }
    
    
public A_BackendAction2Action postUriContextPOST() throws IOException {
          dependencies.isBackend = true;
          apiResponse = postUriContext.postUriContextPOST();
    Report.reportLog(dependencies, "The field postUriContext completed", "INFO", 0, Status.PASS, false, "BackendInvoke postUriContextPOST <strong> POST </strong> completed "
    + "<br> <strong> Url: </strong>" + Utils.prop.getProperty("BACKEND_ENDPOINT") + "/api/users" + " </br>"+ "<strong> Request: </strong></br>"
    + "<textarea readonly>" + postUriContext.jsonBody + " </textarea>",
    "<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
          Report.reportLog(dependencies, "postUriContext action completed", "INFO", 0, Status.PASS, false, "", "", null);
          dependencies.isBackend = false;
          return this;
    }
    
    
    public void doA_BackendAction2Action() throws Exception {

		postPOST2();

		VerdictPost2();

		getGET2();

		VerdictGet2();

		patchPATCH2();

		VerdictPatch2();

		putPUT2();

		VerdictPut2();

		postErrorPOST2();

		VerdictPostError2();

		postUriContextPOST();
    }
}