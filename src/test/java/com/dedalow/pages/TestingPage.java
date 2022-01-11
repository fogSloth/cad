package com.dedalow.pages;

import com.aventstack.extentreports.Status;
import com.dedalow.SharedDependencies;
import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.util.Properties;
import java.util.HashMap;
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
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

public class TestingPage {
    
	private By GetInTestingContext = By.id("I_000000");
	private By GetInTestSuiteModel = By.id("I_000001");
	private By ShowResults = By.xpath("//a[contains(text(),'Show results...')]");
	private By ExecutePlugIn = By.xpath("//span[contains(text(),'Execute plug-in')]");
	private By GenerateAndPush = By.xpath("//a[contains(text(),'Test - Export Test Model Generate and Push')]");
	private By RunGenerateAndPush = By.xpath("//button[contains(text(),'Run...')]");
	private By ExecutePlugIn1 = By.xpath("//span[contains(text(),'Execute plug-in')]");
    
	private By MoveBoxTestingContext_Destination = By.xpath("");
        private By MoveBoxTestingContext = By.id("I_000000");
	private By AddBoxTestingContext_Destination = By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[1]");
        private By AddBoxTestingContext = By.xpath("//*[@id=\"/C/L/f\"]");
	private By AddBoxTestSuiteModel_Destination = By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[1]");
        private By AddBoxTestSuiteModel = By.xpath("//*[@id=\"/C/L/F\"]");
    private JavascriptExecutor js;
    private SharedDependencies dependencies;
    private WebDriver driver;
    private Properties prop;
    private File folderDownloads;

    public TestingPage(SharedDependencies sharedDependencies) {
        this.dependencies = sharedDependencies;
        this.prop = dependencies.prop;
        this.folderDownloads = dependencies.folderDownloads;
        PageFactory.initElements(dependencies.driver, this);
        js = (JavascriptExecutor)dependencies.driver;
    }

    

	public TestingPage GetInTestingContext() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(GetInTestingContext));
            Report.reportLog(dependencies, "Condition GetInTestingContext isClickable finished", "ASYNCHRONOUS", 0);
            Actions action = new Actions(dependencies.driver);
            action.doubleClick(dependencies.driver.findElement(GetInTestingContext)).perform();
            Report.reportLog(dependencies, "Double clicked GetInTestingContext", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }

	public TestingPage GetInTestSuiteModel() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(GetInTestSuiteModel));
            Report.reportLog(dependencies, "Condition GetInTestSuiteModel isClickable finished", "ASYNCHRONOUS", 0);
            Actions action = new Actions(dependencies.driver);
            action.doubleClick(dependencies.driver.findElement(GetInTestSuiteModel)).perform();
            Report.reportLog(dependencies, "Double clicked GetInTestSuiteModel", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }

	public TestingPage ShowResults() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(ShowResults));
            Report.reportLog(dependencies, "Condition ShowResults isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(ShowResults).click();
            Report.reportLog(dependencies, "Clicked ShowResults", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }

	public TestingPage ExecutePlugIn() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(ExecutePlugIn));
            Report.reportLog(dependencies, "Condition ExecutePlugIn isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(ExecutePlugIn).click();
            Report.reportLog(dependencies, "Clicked ExecutePlugIn", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }

	public TestingPage GenerateAndPush() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(GenerateAndPush));
            Report.reportLog(dependencies, "Condition GenerateAndPush isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(GenerateAndPush).click();
            Report.reportLog(dependencies, "Clicked GenerateAndPush", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }

	public TestingPage RunGenerateAndPush() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(RunGenerateAndPush));
            Report.reportLog(dependencies, "Condition RunGenerateAndPush isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(RunGenerateAndPush).click();
            Report.reportLog(dependencies, "Clicked RunGenerateAndPush", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }

	public TestingPage ExecutePlugIn1() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(ExecutePlugIn1));
            Report.reportLog(dependencies, "Condition ExecutePlugIn1 isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(ExecutePlugIn1).click();
            Report.reportLog(dependencies, "Clicked ExecutePlugIn1", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }
    public TestingPage MoveBoxTestingContext() {
        Actions action = new Actions(dependencies.driver);
        action.dragAndDropBy(dependencies.driver.findElement(MoveBoxTestingContext), 200, 0).release().build().perform();
        Report.reportLog(dependencies, "Drag and drop from MoveBoxTestingContext to MoveBoxTestingContext_Destination", "INFO", 1000, Status.PASS, true, "", "", null);
        Report.reportLog(dependencies, "MoveBoxTestingContext action completed", "INFO", 1000, Status.PASS, true, "", "", null);
        return this;
    }
    public TestingPage AddBoxTestingContext() {
        Actions action = new Actions(dependencies.driver);
        action.dragAndDrop(dependencies.driver.findElement(AddBoxTestingContext), dependencies.driver.findElement(AddBoxTestingContext_Destination)).release().build().perform();
        Report.reportLog(dependencies, "Drag and drop from AddBoxTestingContext to AddBoxTestingContext_Destination", "INFO", 1000, Status.PASS, true, "", "", null);
        Report.reportLog(dependencies, "AddBoxTestingContext action completed", "INFO", 1000, Status.PASS, true, "", "", null);
        return this;
    }
    public TestingPage AddBoxTestSuiteModel() {
        Actions action = new Actions(dependencies.driver);
        action.dragAndDrop(dependencies.driver.findElement(AddBoxTestSuiteModel), dependencies.driver.findElement(AddBoxTestSuiteModel_Destination)).release().build().perform();
        Report.reportLog(dependencies, "Drag and drop from AddBoxTestSuiteModel to AddBoxTestSuiteModel_Destination", "INFO", 1000, Status.PASS, true, "", "", null);
        Report.reportLog(dependencies, "AddBoxTestSuiteModel action completed", "INFO", 1000, Status.PASS, true, "", "", null);
        return this;
    }
    
}