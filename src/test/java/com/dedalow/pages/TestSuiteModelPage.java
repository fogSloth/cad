package com.dedalow.pages;

import com.aventstack.extentreports.Status;
import com.dedalow.SharedDependencies;
import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import java.io.File;
import java.util.Properties;
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

public class TestSuiteModelPage {
    
	private By GetInTestCaseModel = By.id("I_000000");
    
    private JavascriptExecutor js;
    private SharedDependencies dependencies;
    private WebDriver driver;
    private Properties prop;
    private File folderDownloads;
    
    public TestSuiteModelPage(SharedDependencies sharedDependencies) {
        this.dependencies = sharedDependencies;
        this.prop = dependencies.prop;
        this.folderDownloads = dependencies.folderDownloads;
        PageFactory.initElements(dependencies.driver, this);
        js = (JavascriptExecutor)dependencies.driver;
    }

    

	public TestSuiteModelPage GetInTestCaseModel() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(GetInTestCaseModel));
            Report.reportLog(dependencies, "Condition GetInTestCaseModel isClickable finished", "ASYNCHRONOUS", 0);
            Actions action = new Actions(dependencies.driver);
            action.doubleClick(dependencies.driver.findElement(GetInTestCaseModel)).perform();
            Report.reportLog(dependencies, "Double clicked GetInTestCaseModel", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }
    
}