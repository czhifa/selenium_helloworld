package com.asurion.optimalpath.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public static String EmailFieldXpath = "//input[@id='Email']";
	public static String PasswordFieldXpath = "//input[@id='Password']";
	public static String LoginButtonXpath = "//input[@class='button-1 login-button']";

	public static WebElement EmailFieldWebElement(WebDriver driver) {
		return driver.findElement(By.xpath(EmailFieldXpath));
	}

	public static WebElement PasswordFieldWebElement(WebDriver driver) {
		return driver.findElement(By.xpath(PasswordFieldXpath));
	}

	public static WebElement LoginButtonWebElement(WebDriver driver) {
		return driver.findElement(By.xpath(LoginButtonXpath));
	}

}