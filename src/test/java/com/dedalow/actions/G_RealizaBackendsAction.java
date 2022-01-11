package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;



import com.dedalow.request.patch;
	import com.dedalow.request.get;
	import com.dedalow.request.put;
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

public class G_RealizaBackendsAction {
    
    private String finalResult;
    private SharedDependencies dependencies;
    public Response apiResponse;
    private patch patch;
	private get get;
	private put put;
	private post post;
	private postError postError;
	
    
    
    

    public G_RealizaBackendsAction(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);
        patch = new patch();
	get = new get();
	put = new put();
	post = new post();
	postError = new postError();
	
        
        
        
    }
    

	public G_RealizaBackendsAction postPOST() throws Exception {
            dependencies.isBackend = true;
            apiResponse = post.postPOST();
    		Report.reportLog(dependencies, "The field post completed", "INFO", 0, Status.PASS, false, "BackendInvoke postPOST <strong> POST </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in/api/users" + " </br>"+ "<strong> Request: </strong></br>"
    		+ "<textarea readonly>" + post.jsonBody + " </textarea>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "postPOST action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public G_RealizaBackendsAction VerdictPost() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(apiResponse.getHeader("Content-Type").contains("utf-8"),
            "Error assertion BackendAssertion1 check the Header return Content-Type: "
            + apiResponse.getHeader("Content-Type") + ", expected contains utf-8");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion1 check the Header return Content-Type: "
            + apiResponse.getHeader("Content-Type") + ", expected contains utf-8", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion1 check the Header <br><strong>return</strong> Content-Type: "  + apiResponse.getHeader("Content-Type")
            + ",</br> <strong> expected </strong> contains utf-8", "backendAssertion", null);
            
            
            assertTrue(apiResponse.jsonPath().getString("job").contains("leader"),
            "Error assertion BackendAssertion2 check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected contains leader");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion2 check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected contains leader", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion2 check the Body <br><strong>return</strong> job: "  + apiResponse.jsonPath().getString("job")
            + ",</br> <strong> expected </strong> contains leader", "backendAssertion", null);
            
            
			
        	assertTrue(201 == apiResponse.getStatusCode(),
        	"VerdictPost returns " + apiResponse.getStatusCode()
        	+ " status code, expected 201");
        	Report.reportLog(dependencies, "Correct assertion in VerdictPost returns "
        	+ apiResponse.getStatusCode() + " status code, expected 201", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPost <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 201", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictPost action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
	public G_RealizaBackendsAction getGET() throws Exception {
            dependencies.isBackend = true;
            apiResponse = get.getGET();
    		Report.reportLog(dependencies, "The field get completed", "INFO", 0, Status.PASS, false, "BackendInvoke getGET <strong> GET </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in/api/users" + " </br>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "getGET action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public G_RealizaBackendsAction VerdictGet() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(apiResponse.jsonPath().getString("support").contains("[text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]"),
            "Error assertion BackendAssertion3 check the Body return support: "
            + apiResponse.jsonPath().getString("support") + ", expected contains [text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion3 check the Body return support: "
            + apiResponse.jsonPath().getString("support") + ", expected contains [text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion3 check the Body <br><strong>return</strong> support: "  + apiResponse.jsonPath().getString("support")
            + ",</br> <strong> expected </strong> contains [text:To keep ReqRes free, contributions towards server costs are appreciated!, url:https://reqres.in/#support-heading]", "backendAssertion", null);
            
            
			
        	assertTrue(200 == apiResponse.getStatusCode(),
        	"VerdictGet returns " + apiResponse.getStatusCode()
        	+ " status code, expected 200");
        	Report.reportLog(dependencies, "Correct assertion in VerdictGet returns "
        	+ apiResponse.getStatusCode() + " status code, expected 200", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictGet <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 200", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictGet action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
	public G_RealizaBackendsAction patchPATCH() throws Exception {
            dependencies.isBackend = true;
            apiResponse = patch.patchPATCH();
    		Report.reportLog(dependencies, "The field patch completed", "INFO", 0, Status.PASS, false, "BackendInvoke patchPATCH <strong> PATCH </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in/api/" + " </br>"+ "<strong> Request: </strong></br>"
    		+ "<textarea readonly>" + patch.jsonBody + " </textarea>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "patchPATCH action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public G_RealizaBackendsAction VerdictPatch() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(apiResponse.jsonPath().getString("updatedAt").contains("2022"),
            "Error assertion BackendAssertion4 check the Body return updatedAt: "
            + apiResponse.jsonPath().getString("updatedAt") + ", expected contains 2022");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion4 check the Body return updatedAt: "
            + apiResponse.jsonPath().getString("updatedAt") + ", expected contains 2022", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion4 check the Body <br><strong>return</strong> updatedAt: "  + apiResponse.jsonPath().getString("updatedAt")
            + ",</br> <strong> expected </strong> contains 2022", "backendAssertion", null);
            
            
			
        	assertTrue(200 == apiResponse.getStatusCode(),
        	"VerdictPatch returns " + apiResponse.getStatusCode()
        	+ " status code, expected 200");
        	Report.reportLog(dependencies, "Correct assertion in VerdictPatch returns "
        	+ apiResponse.getStatusCode() + " status code, expected 200", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPatch <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 200", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictPatch action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
	public G_RealizaBackendsAction putPUT() throws Exception {
            dependencies.isBackend = true;
            apiResponse = put.putPUT();
    		Report.reportLog(dependencies, "The field put completed", "INFO", 0, Status.PASS, false, "BackendInvoke putPUT <strong> PUT </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in/api/" + " </br>"+ "<strong> Request: </strong></br>"
    		+ "<textarea readonly>" + put.jsonBody + " </textarea>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "putPUT action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public G_RealizaBackendsAction VerdictPut() throws Exception {
        dependencies.isBackend = true;
        
            assertTrue(!apiResponse.jsonPath().getString("job").contains("jesus"),
            "Error assertion BackendAssertion check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected notContains jesus");
            Report.reportLog(dependencies, "Correct assertion BackendAssertion check the Body return job: "
            + apiResponse.jsonPath().getString("job") + ", expected notContains jesus", "INFO", 0, Status.PASS, false, "Correct assertion BackendAssertion check the Body <br><strong>return</strong> job: "  + apiResponse.jsonPath().getString("job")
            + ",</br> <strong> expected </strong> notContains jesus", "backendAssertion", null);
            
            
			
        	assertTrue(200 == apiResponse.getStatusCode(),
        	"VerdictPut returns " + apiResponse.getStatusCode()
        	+ " status code, expected 200");
        	Report.reportLog(dependencies, "Correct assertion in VerdictPut returns "
        	+ apiResponse.getStatusCode() + " status code, expected 200", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPut <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 200", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictPut action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
	public G_RealizaBackendsAction postErrorPOST() throws Exception {
            dependencies.isBackend = true;
            apiResponse = postError.postErrorPOST();
    		Report.reportLog(dependencies, "The field postError completed", "INFO", 0, Status.PASS, false, "BackendInvoke postErrorPOST <strong> POST </strong> completed "
        	+ "<br> <strong> Url: </strong>" + "https://reqres.in" + " </br>"+ "<strong> Request: </strong></br>"
    		+ "<textarea readonly>" + postError.jsonBody + " </textarea>",
        	"<strong> Response: </strong></br><textarea readonly>" + apiResponse.asString() + "</textarea>", null);
	
            Report.reportLog(dependencies, "postErrorPOST action completed", "INFO", 0, Status.PASS, false, "", "", null);
            dependencies.isBackend = false;
            return this;
            }
		
	public G_RealizaBackendsAction VerdictPostError() throws Exception {
        dependencies.isBackend = true;
        
			
        	assertTrue(201 == apiResponse.getStatusCode(),
        	"VerdictPostError returns " + apiResponse.getStatusCode()
        	+ " status code, expected 201");
        	Report.reportLog(dependencies, "Correct assertion in VerdictPostError returns "
        	+ apiResponse.getStatusCode() + " status code, expected 201", "INFO", 0, Status.PASS, false, "Correct assertion in VerdictPostError <br><strong>returns</strong> "
        	+ apiResponse.getStatusCode() + " status code, </br><strong>expected</strong> 201", "backendAssertion", null);
        Report.reportLog(dependencies, "VerdictPostError action completed", "INFO", 0, Status.PASS, false, "", "", null);
        dependencies.isBackend = false;
        return this;
        }
		
    public void doG_RealizaBackendsAction() throws Exception {
		

		postPOST();

		VerdictPost();

		getGET();

		VerdictGet();

		patchPATCH();

		VerdictPatch();

		putPUT();

		VerdictPut();

		postErrorPOST();

		VerdictPostError();
    }
}