package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;



import com.dedalow.request.post;
	import com.dedalow.request.postError;
	import com.dedalow.request.patch;
	import com.dedalow.request.get;
	import com.dedalow.request.put;
	
    import org.openqa.selenium.remote.LocalFileDetector;
    import org.openqa.selenium.remote.RemoteWebElement;
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

public class G_GivenBackendsAction {
    
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    private post post;
	private postError postError;
	private patch patch;
	private get get;
	private put put;
	
    
    
    

    public G_GivenBackendsAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        post = new post();
	postError = new postError();
	patch = new patch();
	get = new get();
	put = new put();
	
        
        
        
    }
    

	public G_GivenBackendsAction postPOST3() throws Exception {
            dependencies.isBackend = true;
            apiResponse = post.postPOST3();
    		Report.reportLog(dependencies, "The field post3 completed", "INFO", 0, Status.PASS, false, "BackendInvoke postPOST3 <strong> POST </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in/api/users" + " </br>"+ "<strong> Request: </strong></br>"
    		+ "<textarea readonly>" + post.jsonBody + " </textarea>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "postPOST3 action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public G_GivenBackendsAction VerdictPost3() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(apiResponse.getHeader("Content-Type").contains("utf-8"),
            "Error assertion BackendAssertion16 check the Header return Content-Type: "
            + apiResponse.getHeader("Content-Type") + ", expected contains utf-8");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion16 check the Header return Content-Type: "
            + apiResponse.getHeader("Content-Type") + ", expected contains utf-8", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion16 check the Header <br><strong>return</strong> Content-Type: "  + apiResponse.getHeader("Content-Type")
            + ",</br> <strong> expected </strong> contains utf-8", "backendAssertion", null);
            
            
            assertTrue(apiResponse.jsonPath().getString("job").contains("leader"),
            "Error assertion BackendAssertion17 check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected contains leader");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion17 check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected contains leader", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion17 check the Body <br><strong>return</strong> job: "  + apiResponse.jsonPath().getString("job")
            + ",</br> <strong> expected </strong> contains leader", "backendAssertion", null);
            
            
			
        	assertTrue(201 == apiResponse.getStatusCode(),
        	"VerdictPost3 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 201");
        	Report.reportLog(dependencies, "Correct assertion in VerdictPost3 returns "
        	+ apiResponse.getStatusCode() + " status code, expected 201", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPost3 <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 201", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictPost3 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
	public G_GivenBackendsAction getGET3() throws Exception {
            dependencies.isBackend = true;
            apiResponse = get.getGET3();
    		Report.reportLog(dependencies, "The field get3 completed", "INFO", 0, Status.PASS, false, "BackendInvoke getGET3 <strong> GET </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in/api/users" + " </br>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "getGET3 action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public G_GivenBackendsAction VerdictGet3() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(apiResponse.jsonPath().getString("support").contains("[text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]"),
            "Error assertion BackendAssertion18 check the Body return support: "
            + apiResponse.jsonPath().getString("support") + ", expected contains [text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion18 check the Body return support: "
            + apiResponse.jsonPath().getString("support") + ", expected contains [text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion18 check the Body <br><strong>return</strong> support: "  + apiResponse.jsonPath().getString("support")
            + ",</br> <strong> expected </strong> contains [text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]", "backendAssertion", null);
            
            
			
        	assertTrue(200 == apiResponse.getStatusCode(),
        	"VerdictGet3 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 200");
        	Report.reportLog(dependencies, "Correct assertion in VerdictGet3 returns "
        	+ apiResponse.getStatusCode() + " status code, expected 200", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictGet3 <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 200", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictGet3 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
	public G_GivenBackendsAction patchPATCH3() throws Exception {
            dependencies.isBackend = true;
            apiResponse = patch.patchPATCH3();
    		Report.reportLog(dependencies, "The field patch3 completed", "INFO", 0, Status.PASS, false, "BackendInvoke patchPATCH3 <strong> PATCH </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in/api/" + " </br>"+ "<strong> Request: </strong></br>"
    		+ "<textarea readonly>" + patch.jsonBody + " </textarea>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "patchPATCH3 action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public G_GivenBackendsAction VerdictPatch3() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(apiResponse.jsonPath().getString("updatedAt").contains("2022"),
            "Error assertion BackendAssertion15 check the Body return updatedAt: "
            + apiResponse.jsonPath().getString("updatedAt") + ", expected contains 2022");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion15 check the Body return updatedAt: "
            + apiResponse.jsonPath().getString("updatedAt") + ", expected contains 2022", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion15 check the Body <br><strong>return</strong> updatedAt: "  + apiResponse.jsonPath().getString("updatedAt")
            + ",</br> <strong> expected </strong> contains 2022", "backendAssertion", null);
            
            
			
        	assertTrue(200 == apiResponse.getStatusCode(),
        	"VerdictPatch3 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 200");
        	Report.reportLog(dependencies, "Correct assertion in VerdictPatch3 returns "
        	+ apiResponse.getStatusCode() + " status code, expected 200", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPatch3 <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 200", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictPatch3 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
	public G_GivenBackendsAction putPUT3() throws Exception {
            dependencies.isBackend = true;
            apiResponse = put.putPUT3();
    		Report.reportLog(dependencies, "The field put3 completed", "INFO", 0, Status.PASS, false, "BackendInvoke putPUT3 <strong> PUT </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in/api/" + " </br>"+ "<strong> Request: </strong></br>"
    		+ "<textarea readonly>" + put.jsonBody + " </textarea>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "putPUT3 action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public G_GivenBackendsAction VerdictPut3() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(!apiResponse.jsonPath().getString("job").contains("jesus"),
            "Error assertion BackendAssertion19 check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected notContains jesus");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion19 check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected notContains jesus", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion19 check the Body <br><strong>return</strong> job: "  + apiResponse.jsonPath().getString("job")
            + ",</br> <strong> expected </strong> notContains jesus", "backendAssertion", null);
            
            
			
        	assertTrue(200 == apiResponse.getStatusCode(),
        	"VerdictPut3 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 200");
        	Report.reportLog(dependencies, "Correct assertion in VerdictPut3 returns "
        	+ apiResponse.getStatusCode() + " status code, expected 200", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPut3 <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 200", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictPut3 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
	public G_GivenBackendsAction postErrorPOST3() throws Exception {
            dependencies.isBackend = true;
            apiResponse = postError.postErrorPOST3();
    		Report.reportLog(dependencies, "The field postError3 completed", "INFO", 0, Status.PASS, false, "BackendInvoke postErrorPOST3 <strong> POST </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in" + " </br>"+ "<strong> Request: </strong></br>"
    		+ "<textarea readonly>" + postError.jsonBody + " </textarea>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "postErrorPOST3 action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public G_GivenBackendsAction VerdictPostError3() throws Exception {
        dependencies.isBackend = true;
        
			
        	assertTrue(201 == apiResponse.getStatusCode(),
        	"VerdictPostError3 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 201");
        	Report.reportLog(dependencies, "Correct assertion in VerdictPostError3 returns "
        	+ apiResponse.getStatusCode() + " status code, expected 201", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPostError3 <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 201", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictPostError3 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
    public void doG_GivenBackendsAction() throws Exception {
		

		postPOST3();

		VerdictPost3();

		getGET3();

		VerdictGet3();

		patchPATCH3();

		VerdictPatch3();

		putPUT3();

		VerdictPut3();

		postErrorPOST3();

		VerdictPostError3();
    }
}