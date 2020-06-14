package com.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class common {
	
	public static WebDriver intializeWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\My God\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
