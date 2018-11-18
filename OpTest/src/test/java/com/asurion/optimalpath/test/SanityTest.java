package com.asurion.optimalpath.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.asurion.optimalpath.page.objects.HomePage;

public class SanityTest extends BaseTest {

    HomePage homePage = new HomePage();

    @BeforeMethod
    public void delayTest() throws Exception {
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void getPageTittle() throws Exception {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Optimal Path";
        if (actualTitle.equalsIgnoreCase(expectedTitle)) ;
    }

    @Test(priority = 1)
    public void startInterview() throws Exception {
        WebElement startInterview = homePage.startInterviewBtnWebElement(driver);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", startInterview);

    }

    @Test(priority = 2)
    public void checkBoxSelection() throws Exception {
        WebElement checkBox = homePage.menuStartBtnWebElement(driver);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", checkBox);

    }

    @Test(priority = 3)
    public void contractSubmit() throws Exception {
        WebElement contractSubmit = homePage.contractSubmitBtnXpathWebElement(driver);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", contractSubmit);

    }

    @Test(priority = 4)
    public void searchDevice() throws Exception {
        //JavascriptExecutor executor = (JavascriptExecutor)driver;

        homePage.SearchDeviceBtnWebElement(driver).sendKeys("c");
        homePage.SearchDeviceBtnWebElement(driver).sendKeys(Keys.ENTER);
        //String s1="document.getElementById('searchBox').value='c\n'";
        //executor.executeScript(s1);
    }

    public String waitForElement(String item) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(item)));
        return item;
    }

	/*@Test(dataProvider = "LoginData")
	public void LoginTestCase(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		//HomePage.LoginLinkWebElement(driver).click();
		LoginPage.EmailFieldWebElement(driver).sendKeys(username);
		LoginPage.PasswordFieldWebElement(driver).sendKeys(password);
		System.out.println(driver.getTitle());
	}

	@DataProvider(name = "LoginData")
	public Object[][] LoginTestData() throws Exception {
		ExcelReader ER = new ExcelReader();
		return ER.getExceData();
	}*/

}