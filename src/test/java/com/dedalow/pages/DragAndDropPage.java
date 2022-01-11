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

public class DragAndDropPage {
    
	private By enableDrag = By.id("initEvents");
	private By enableDrag1 = By.id("initEvents");
    
	private By dragImage_Destination = By.id("dropArea");
        private By dragImage = By.id("imageToDrop");
	private By dragImage_Destination1 = By.id("dropArea");
        private By dragImage1 = By.id("imageToDrop");
    private JavascriptExecutor js;
    private SharedDependencies dependencies;
    private WebDriver driver;
    private Properties prop;
    private File folderDownloads;

    public DragAndDropPage(SharedDependencies sharedDependencies) {
        this.dependencies = sharedDependencies;
        this.prop = dependencies.prop;
        this.folderDownloads = dependencies.folderDownloads;
        PageFactory.initElements(dependencies.driver, this);
        js = (JavascriptExecutor)dependencies.driver;
    }

    

	public DragAndDropPage enableDrag() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(enableDrag));
            Report.reportLog(dependencies, "Condition enableDrag isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(enableDrag).click();
            Report.reportLog(dependencies, "Clicked enableDrag", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public DragAndDropPage enableDrag1() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(enableDrag1));
            Report.reportLog(dependencies, "Condition enableDrag1 isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(enableDrag1).click();
            Report.reportLog(dependencies, "Clicked enableDrag1", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }
    public DragAndDropPage dragImage() {
        Actions action = new Actions(dependencies.driver);
        action.dragAndDrop(dependencies.driver.findElement(dragImage), dependencies.driver.findElement(dragImage_Destination)).release().build().perform();
        Report.reportLog(dependencies, "Drag and drop from dragImage to dragImage_Destination", "INFO", 0, Status.PASS, true, "", "", null);
        Report.reportLog(dependencies, "dragImage action completed", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }
    public DragAndDropPage dragImage1() {
        Actions action = new Actions(dependencies.driver);
        action.dragAndDrop(dependencies.driver.findElement(dragImage1), dependencies.driver.findElement(dragImage_Destination1)).release().build().perform();
        Report.reportLog(dependencies, "Drag and drop from dragImage1 to dragImage_Destination1", "INFO", 0, Status.PASS, true, "", "", null);
        Report.reportLog(dependencies, "dragImage1 action completed", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }
    
}