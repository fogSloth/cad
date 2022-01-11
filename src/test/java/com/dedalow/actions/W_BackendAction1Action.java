package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;



import com.dedalow.request.put;
	import com.dedalow.request.get;
	import com.dedalow.request.patch;
	import com.dedalow.request.post;
	import com.dedalow.request.postError;
	
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

public class W_BackendAction1Action {
    
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    private put put;
	private get get;
	private patch patch;
	private post post;
	private postError postError;
	
    
    private A_BackendAction2Action a_BackendAction2Action;
	
    

    public W_BackendAction1Action(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        put = new put();
	get = new get();
	patch = new patch();
	post = new post();
	postError = new postError();
	
        a_BackendAction2Action = new A_BackendAction2Action(dependencies);
	
        
        
    }
    

	public W_BackendAction1Action postPOST1() throws Exception {
            dependencies.isBackend = true;
            apiResponse = post.postPOST1();
    		Report.reportLog(dependencies, "The field post1 completed", "INFO", 0, Status.PASS, false, "BackendInvoke postPOST1 <strong> POST </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in/api/users" + " </br>"+ "<strong> Request: </strong></br>"
    		+ "<textarea readonly>" + post.jsonBody + " </textarea>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "postPOST1 action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public W_BackendAction1Action VerdictPost1() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(apiResponse.getHeader("Content-Type").contains("utf-8"),
            "Error assertion BackendAssertion5 check the Header return Content-Type: "
            + apiResponse.getHeader("Content-Type") + ", expected contains utf-8");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion5 check the Header return Content-Type: "
            + apiResponse.getHeader("Content-Type") + ", expected contains utf-8", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion5 check the Header <br><strong>return</strong> Content-Type: "  + apiResponse.getHeader("Content-Type")
            + ",</br> <strong> expected </strong> contains utf-8", "backendAssertion", null);
            
            
            assertTrue(apiResponse.jsonPath().getString("job").contains("leader"),
            "Error assertion BackendAssertion6 check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected contains leader");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion6 check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected contains leader", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion6 check the Body <br><strong>return</strong> job: "  + apiResponse.jsonPath().getString("job")
            + ",</br> <strong> expected </strong> contains leader", "backendAssertion", null);
            
            
			
        	assertTrue(201 == apiResponse.getStatusCode(),
        	"VerdictPost1 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 201");
        	Report.reportLog(dependencies, "Correct assertion in VerdictPost1 returns "
        	+ apiResponse.getStatusCode() + " status code, expected 201", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPost1 <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 201", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictPost1 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
	public W_BackendAction1Action getGET1() throws Exception {
            dependencies.isBackend = true;
            apiResponse = get.getGET1();
    		Report.reportLog(dependencies, "The field get1 completed", "INFO", 0, Status.PASS, false, "BackendInvoke getGET1 <strong> GET </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in/api/users" + " </br>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "getGET1 action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public W_BackendAction1Action VerdictGet1() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(apiResponse.jsonPath().getString("support").contains("[text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]"),
            "Error assertion BackendAssertion7 check the Body return support: "
            + apiResponse.jsonPath().getString("support") + ", expected contains [text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion7 check the Body return support: "
            + apiResponse.jsonPath().getString("support") + ", expected contains [text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion7 check the Body <br><strong>return</strong> support: "  + apiResponse.jsonPath().getString("support")
            + ",</br> <strong> expected </strong> contains [text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]", "backendAssertion", null);
            
            
			
        	assertTrue(200 == apiResponse.getStatusCode(),
        	"VerdictGet1 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 200");
        	Report.reportLog(dependencies, "Correct assertion in VerdictGet1 returns "
        	+ apiResponse.getStatusCode() + " status code, expected 200", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictGet1 <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 200", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictGet1 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
	public W_BackendAction1Action patchPATCH1() throws Exception {
            dependencies.isBackend = true;
            apiResponse = patch.patchPATCH1();
    		Report.reportLog(dependencies, "The field patch1 completed", "INFO", 0, Status.PASS, false, "BackendInvoke patchPATCH1 <strong> PATCH </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in/api/" + " </br>"+ "<strong> Request: </strong></br>"
    		+ "<textarea readonly>" + patch.jsonBody + " </textarea>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "patchPATCH1 action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public W_BackendAction1Action VerdictPatch1() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(apiResponse.jsonPath().getString("updatedAt").contains("2022"),
            "Error assertion BackendAssertion8 check the Body return updatedAt: "
            + apiResponse.jsonPath().getString("updatedAt") + ", expected contains 2022");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion8 check the Body return updatedAt: "
            + apiResponse.jsonPath().getString("updatedAt") + ", expected contains 2022", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion8 check the Body <br><strong>return</strong> updatedAt: "  + apiResponse.jsonPath().getString("updatedAt")
            + ",</br> <strong> expected </strong> contains 2022", "backendAssertion", null);
            
            
			
        	assertTrue(200 == apiResponse.getStatusCode(),
        	"VerdictPatch1 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 200");
        	Report.reportLog(dependencies, "Correct assertion in VerdictPatch1 returns "
        	+ apiResponse.getStatusCode() + " status code, expected 200", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPatch1 <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 200", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictPatch1 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
	public W_BackendAction1Action putPUT1() throws Exception {
            dependencies.isBackend = true;
            apiResponse = put.putPUT1();
    		Report.reportLog(dependencies, "The field put1 completed", "INFO", 0, Status.PASS, false, "BackendInvoke putPUT1 <strong> PUT </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in/api/" + " </br>"+ "<strong> Request: </strong></br>"
    		+ "<textarea readonly>" + put.jsonBody + " </textarea>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "putPUT1 action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public W_BackendAction1Action VerdictPut1() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(!apiResponse.jsonPath().getString("job").contains("jesus"),
            "Error assertion BackendAssertion9 check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected notContains jesus");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion9 check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected notContains jesus", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion9 check the Body <br><strong>return</strong> job: "  + apiResponse.jsonPath().getString("job")
            + ",</br> <strong> expected </strong> notContains jesus", "backendAssertion", null);
            
            
			
        	assertTrue(200 == apiResponse.getStatusCode(),
        	"VerdictPut1 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 200");
        	Report.reportLog(dependencies, "Correct assertion in VerdictPut1 returns "
        	+ apiResponse.getStatusCode() + " status code, expected 200", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPut1 <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 200", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictPut1 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
	public W_BackendAction1Action postErrorPOST1() throws Exception {
            dependencies.isBackend = true;
            apiResponse = postError.postErrorPOST1();
    		Report.reportLog(dependencies, "The field postError1 completed", "INFO", 0, Status.PASS, false, "BackendInvoke postErrorPOST1 <strong> POST </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in" + " </br>"+ "<strong> Request: </strong></br>"
    		+ "<textarea readonly>" + postError.jsonBody + " </textarea>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "postErrorPOST1 action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public W_BackendAction1Action VerdictPostError1() throws Exception {
        dependencies.isBackend = true;
        
			
        	assertTrue(201 == apiResponse.getStatusCode(),
        	"VerdictPostError1 returns " + apiResponse.getStatusCode()
        	+ " status code, expected 201");
        	Report.reportLog(dependencies, "Correct assertion in VerdictPostError1 returns "
        	+ apiResponse.getStatusCode() + " status code, expected 201", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPostError1 <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 201", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictPostError1 action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		

    public void doW_BackendAction1Action() throws Exception {
		

		postPOST1();

		VerdictPost1();

		getGET1();

		VerdictGet1();

		patchPATCH1();

		VerdictPatch1();

		putPUT1();

		VerdictPut1();

		postErrorPOST1();

		VerdictPostError1();

		a_BackendAction2Action.doA_BackendAction2Action();
            	Report.reportLog(dependencies, "A_BackendAction2Action action completed", "INFO", 0, Status.PASS, false, "", "", null);
    }
}