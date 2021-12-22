package com.dedalow.customActions;

import com.dedalow.actions.G_RealizaCustomAction;



import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.RunnerTest;
import com.dedalow.SharedDependencies;

public class CustomActionPagAleatoria {

    private SharedDependencies dependencies;

    /**
     * Constructor
     * 
     * @param sharedDependencies
     * @throws Exception
     */
    public CustomActionPagAleatoria(SharedDependencies sharedDependencies) throws Exception {
        this.dependencies = sharedDependencies;
        PageFactory.initElements(dependencies.driver, this);

    }


    /**
     * Space for user-defined methods
     */
    
    
    /**
     * Class method called from the TestCase thread. Add inside the order of funcions calls desired.
     * 
     * @throws Exception
     */
    public void doCustomActionPagAleatoria() throws Exception {
        dependencies.driver.findElement(By.xpath("//a[@href=\"/wiki/Especial:Aleatoria\"]")).click();
        Report.reportLog(dependencies, "CustomActionPagAleatoria action completed", "INFO", 0);
    }
}
