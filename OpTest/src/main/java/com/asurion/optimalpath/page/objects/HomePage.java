package com.asurion.optimalpath.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    String StartInterviewBtnXpath = "//*[@id='home-start']";
    String MenuStartBtnXpath = "//*[@id='selection-0-0']";
    String contractSubmitBtnXpath = "//*[@id='enter-contract-submit']";
    String SearchDeviceXpath = "//*[@id='searchBox']";

    public WebElement startInterviewBtnWebElement(WebDriver driver) {
        return driver.findElement(By.xpath(StartInterviewBtnXpath));
    }

    public WebElement menuStartBtnWebElement(WebDriver driver) {
        return driver.findElement(By.xpath(MenuStartBtnXpath));
    }

    public WebElement contractSubmitBtnXpathWebElement(WebDriver driver) {
        return driver.findElement(By.xpath(contractSubmitBtnXpath));
    }

    public WebElement SearchDeviceBtnWebElement(WebDriver driver) {
        return driver.findElement(By.xpath(SearchDeviceXpath));
    }

}
