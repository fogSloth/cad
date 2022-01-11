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

public class FromPage {
    
	private By fillInputs1 = By.id("name");
	private By nameById1 = By.id("name");
	private By lastNameByXpathAndDoubleQuote1 = By.xpath("//input[@id=\"lastName\"]");
	private By emailByXpathAndSingleQuote1 = By.xpath("//input[@id='email']");
	private By phoneByName1 = By.name("phone");
    
    private JavascriptExecutor js;
    private SharedDependencies dependencies;
    private WebDriver driver;
    private Properties prop;
    private File folderDownloads;

    public FromPage(SharedDependencies sharedDependencies) {
        this.dependencies = sharedDependencies;
        this.prop = dependencies.prop;
        this.folderDownloads = dependencies.folderDownloads;
        PageFactory.initElements(dependencies.driver, this);
        js = (JavascriptExecutor)dependencies.driver;
    }

    

	public FromPage fillInputs1() throws Exception {
        	dependencies.driver.findElement(nameById1).clear();
            dependencies.driver.findElement(nameById1).sendKeys("a name");
            Report.reportLog(dependencies, "Typed " + "a name in nameById1", "INFO", 0, Status.PASS, true, "", "", null);
			dependencies.driver.findElement(lastNameByXpathAndDoubleQuote1).clear();
            dependencies.driver.findElement(lastNameByXpathAndDoubleQuote1).sendKeys("a last name");
            Report.reportLog(dependencies, "Typed " + "a last name in lastNameByXpathAndDoubleQuote1", "INFO", 0, Status.PASS, true, "", "", null);
			dependencies.driver.findElement(emailByXpathAndSingleQuote1).clear();
            dependencies.driver.findElement(emailByXpathAndSingleQuote1).sendKeys("an email");
            Report.reportLog(dependencies, "Typed " + "an email in emailByXpathAndSingleQuote1", "INFO", 0, Status.PASS, true, "", "", null);
			dependencies.driver.findElement(phoneByName1).clear();
            dependencies.driver.findElement(phoneByName1).sendKeys("123456");
            Report.reportLog(dependencies, "Typed " + "123456 in phoneByName1", "INFO", 0, Status.PASS, true, "", "", null);
		
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(fillInputs1));
            Report.reportLog(dependencies, "Condition fillInputs1 isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(fillInputs1).click();
            Report.reportLog(dependencies, "Clicked fillInputs1", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }
    
}