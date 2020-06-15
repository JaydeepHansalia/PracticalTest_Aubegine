package com.main;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartPage {

	static WebDriver driver = common.intializeWebDriver();

	public static void SearchFlipkartInGoogle() {
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Flipkart");
	}

	public static void PrintSearchOptions() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> links = driver.findElements(By.xpath("//ul[@class='erkvQe']/li"));
		int count = links.size();
		for (int i = 1; i <= count; i++) {
			String searchoption = driver.findElement(By.xpath("//ul[@class='erkvQe']/li[" + i + "]")).getText();
			System.out.println(searchoption);
		}
	}

	public static void openFlipkartPage() {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='rso']//div//a[@href='https://www.flipkart.com/']")).click();
	}

	public static void closeLoginPopup() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	}

	public static void navigateOnWindowsAcPage() {
		WebElement Tv_Appliances = driver.findElement(By.xpath("//span[contains(text(),'TVs & Appliances')]"));
		Actions hover = new Actions(driver);
		hover.moveToElement(Tv_Appliances).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Window ACs')]")).click();
	}

	public static void clickOnAddtoCompareCheckbox() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Click on 2md and 3rd products checkbox
		driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C']/div[3]//div[@class='_1p7h2j']")).click();
		driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C']/div[4]//div[@class='_1p7h2j']")).click();

		// Click on compare button
		driver.findElement(By.xpath("//span[contains(text(),'COMPARE')]")).click();
	}

	public static void addAnotherProduct() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Select Samsung Brand
		driver.findElement(By.xpath("//div[@class='col-2-5']/div[1]//div[contains(text(),'Choose Brand')]")).click();
		driver.findElement(By.xpath("//div[@class='LG4KV_']//div[@class='_2KISpu'][contains(text(),'Samsung')]"))
				.click();

		// Select any product
		driver.findElement(By.xpath("//div[@class='col-2-5']/div[1]//div[contains(text(),'Choose a Product')]"))
				.click();
		driver.findElement(By.xpath("//div[contains(text(),'Samsung 1.5 Ton 5 Star Split Triple Inverter Dura')]"))
				.click();
	}

	public static void printNameAndPrice() {
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='col-4-5']/div[1]/div"));
		int numberofproducts = products.size();

		for (int i = 2; i <= numberofproducts; i++) {
			String productname = driver.findElement(By.xpath("//div[@class='col-4-5']/div[1]/div[" + i + "]"))
					.getText();
			System.out.println(productname);

			String productprice = driver
					.findElement(By.xpath("//div[@class='col-4-5']/div[2]/div[" + i + "]//div[@class='_1vC4OE']"))
					.getText();
			System.out.println(productprice);
		}
	}

	public static void addProductInCart() {
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='_2lK_YI']/div[5]/div"));
		int totalproducts = products.size();

		for (int i = 2; i <= totalproducts; i++) {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement addtocartbutton = driver.findElement(By.xpath(
					"//div[@class='_2lK_YI']/div[5]/div[" + i + "]/button[@class='_2AkmmA _2Npkh4 _2MWPVK e1kKGU']"));
			addtocartbutton.click();
			WebDriverWait wait= new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Place Order')]")));
			if(i==totalproducts) {
				break;
			}
			driver.navigate().back();
		}
	}
	
	public static void checkAvailability() {
		driver.findElement(By.xpath("//input[@placeholder='Enter delivery pincode']")).sendKeys("360410");
		driver.findElement(By.xpath("//span[contains(text(),'Check')]")).click();
		String getthelocation= driver.findElement(By.xpath("//div[@class='_2LG8B7']/span")).getText();
		System.out.println(getthelocation);
	}
	
	public static void checkAvailabilityOnChangePincode() {
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//div[@class='_2LG8B7']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter delivery pincode']")).sendKeys("380061");
		driver.findElement(By.xpath("//span[contains(text(),'Check')]")).click();
		String getthelocationonchangecode= driver.findElement(By.xpath("//div[@class='_2LG8B7']/span")).getText();
		System.out.println(getthelocationonchangecode);
		driver.close();
		driver.quit();
	}

}
