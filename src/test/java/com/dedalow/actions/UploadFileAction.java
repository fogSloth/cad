package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.utils.Constant;
import com.dedalow.report.Report;
import io.restassured.response.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class UploadFileAction{

    private Class reflectiveClass;
    private Constant constant;
    private WebDriver driver;
    private String handler;
    private JavascriptExecutor js;
    private Properties prop;
    private String level;
    private String caseName;
    private File folderTestCase;
    private File folderDownloads;
    private String finalResult;
    private HashMap<String, String> excelSheet;
    
	private static GoToAppGlobalAction goToAppGlobalAction;
      
	private By downloadFile = By.xpath("//button[contains(text(), 'Download uploadFilefileName')]");
	private By dummyClickToForceWait = By.id("name");
	private By uploadFile = By.id("uploadFile");
    
    public UploadFileAction(Class reflectiveClass) throws Exception {
        this.reflectiveClass = reflectiveClass;
        getPrepareAction();
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor)driver;
		goToAppGlobalAction = new GoToAppGlobalAction(reflectiveClass);
    }

    public void getPrepareAction() throws Exception {
        this.driver = (WebDriver) reflectiveClass.getField("driver").get(reflectiveClass);
        this.constant = (Constant) reflectiveClass.getField("constant").get(reflectiveClass);
        this.prop = (Properties) reflectiveClass.getField("prop").get(reflectiveClass);
        this.level = (String) reflectiveClass.getField("level").get(reflectiveClass);
        this.folderDownloads = (File) reflectiveClass.getField("folderDownloads").get(reflectiveClass);
        this.finalResult = (String) reflectiveClass.getField("finalResult").get(reflectiveClass);
        this.folderTestCase = (File) reflectiveClass.getField("folderTestCase").get(reflectiveClass);
        this.caseName = (String) reflectiveClass.getField("caseName").get(reflectiveClass);
        this.handler = (String) reflectiveClass.getField("handler").get(reflectiveClass);
        this.excelSheet = (HashMap) reflectiveClass.getField("excelSheet").get(reflectiveClass);
    }

    
      
	public UploadFileAction uploadFile() throws Exception {
        
            
            driver.findElement(uploadFile).sendKeys("C:/Users/jperepei/generated/Swagger.json");
            Report.reportLog(reflectiveClass, "uploadFile: C:/Users/jperepei/generated/Swagger.json uploaded", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
      }
      
      
	public UploadFileAction downloadFile() throws Exception {
        
            
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(downloadFile));
            Report.reportLog(reflectiveClass, "Condition downloadFile isClickable finished", "ASYNCHRONOUS", 0);

            driver.findElement(downloadFile).click();
            Report.reportLog(reflectiveClass, "Clicked downloadFile", "INFO", 2000, Status.PASS, true, "", "", null);
            return this;
      }
      
      
	public UploadFileAction dummyClickToForceWait() throws Exception {
        
            
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(dummyClickToForceWait));
            Report.reportLog(reflectiveClass, "Condition dummyClickToForceWait isClickable finished", "ASYNCHRONOUS", 0);

            driver.findElement(dummyClickToForceWait).click();
            Report.reportLog(reflectiveClass, "Clicked dummyClickToForceWait", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
      }
      
    public void doUploadFileAction() throws Exception {
    
    
		goToAppGlobalAction.doGoToAppGlobalAction();
      	Report.reportLog(reflectiveClass, "GoToAppGlobalAction action completed", "INFO", 0, Status.PASS, false, "", "", null);
    
		uploadFile();
    
		downloadFile();
    	Thread.sleep(2000);

		dummyClickToForceWait();
    
		
    }
}