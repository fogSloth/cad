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

public class LoginPage {
    
	private By SingIn = By.id("login");
	private By Password = By.xpath("//input[@id='id_password']");
	private By UserName = By.id("id_username");
    
    private JavascriptExecutor js;
    private SharedDependencies dependencies;
    private WebDriver driver;
    private Properties prop;
    private File folderDownloads;

    public LoginPage(SharedDependencies sharedDependencies) {
        this.dependencies = sharedDependencies;
        this.prop = dependencies.prop;
        this.folderDownloads = dependencies.folderDownloads;
        PageFactory.initElements(dependencies.driver, this);
        js = (JavascriptExecutor)dependencies.driver;
    }

    

	public LoginPage SingIn() throws Exception {
        	dependencies.driver.findElement(Password).clear();
            dependencies.driver.findElement(Password).sendKeys("cadgitlab");
            Report.reportLog(dependencies, "Typed " + "cadgitlab in Password", "INFO", 0, Status.PASS, true, "", "", null);
			dependencies.driver.findElement(UserName).clear();
            dependencies.driver.findElement(UserName).sendKeys("cadgitlab");
            Report.reportLog(dependencies, "Typed " + "cadgitlab in UserName", "INFO", 0, Status.PASS, true, "", "", null);
		
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(SingIn));
            Report.reportLog(dependencies, "Condition SingIn isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(SingIn).click();
            Report.reportLog(dependencies, "Clicked SingIn", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }
    
}