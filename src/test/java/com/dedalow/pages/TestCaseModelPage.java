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

public class TestCaseModelPage {
    
	private By GetInExecute = By.id("I_000002");
    
	private By AddBoxTestCaseModel_Destination = By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[1]");
        private By AddBoxTestCaseModel = By.xpath("//*[@id=\"/C/L/c\"]");
    private JavascriptExecutor js;
    private SharedDependencies dependencies;
    private WebDriver driver;
    private Properties prop;
    private File folderDownloads;
    
    public TestCaseModelPage(SharedDependencies sharedDependencies) {
        this.dependencies = sharedDependencies;
        this.prop = dependencies.prop;
        this.folderDownloads = dependencies.folderDownloads;
        PageFactory.initElements(dependencies.driver, this);
        js = (JavascriptExecutor)dependencies.driver;
    }

    

	public TestCaseModelPage GetInExecute() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(GetInExecute));
            Report.reportLog(dependencies, "Condition GetInExecute isClickable finished", "ASYNCHRONOUS", 0);
            Actions action = new Actions(dependencies.driver);
            action.doubleClick(dependencies.driver.findElement(GetInExecute)).perform();
            Report.reportLog(dependencies, "Double clicked GetInExecute", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }
    public TestCaseModelPage AddBoxTestCaseModel() {
        Actions action = new Actions(dependencies.driver);
        action.dragAndDrop(dependencies.driver.findElement(AddBoxTestCaseModel), dependencies.driver.findElement(AddBoxTestCaseModel_Destination)).release().build().perform();
        Report.reportLog(dependencies, "Drag and drop from AddBoxTestCaseModel to AddBoxTestCaseModel_Destination", "INFO", 1000, Status.PASS, true, "", "", null);
        Report.reportLog(dependencies, "AddBoxTestCaseModel action completed", "INFO", 1000, Status.PASS, true, "", "", null);
        return this;
    }
    
}