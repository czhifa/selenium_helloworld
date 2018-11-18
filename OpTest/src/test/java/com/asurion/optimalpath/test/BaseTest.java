package com.asurion.optimalpath.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import com.asurion.optimalpath.utilities.ReadPropertiesFile;
import com.asurion.optimalpath.utilities.SelectBrowser;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    SelectBrowser select = new SelectBrowser();
    ReadPropertiesFile prop = new ReadPropertiesFile();

    protected WebDriver driver = null;

    @BeforeSuite
    public void launchBrowser() throws Exception {
        driver = select.selectBrowser();
        String url = prop.ReadPropertiesFileByKey("URL");
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }



    /*@AfterTest
    public void closeBrowser() {
        driver.close();
        driver.quit();

    }*/

}
