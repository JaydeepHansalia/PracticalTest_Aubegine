package com.test;

import org.testng.annotations.Test;

import com.main.FlipkartPage;

public class Test_Flipkart {
	
	@Test(priority=1)
	public void searchFlipkart() {
		FlipkartPage.SearchFlipkartInGoogle();
	}
	
	@Test(priority=2)
	public void getListOfSearch() {
		FlipkartPage.PrintSearchOptions();
	}
	
	@Test(priority=3)
	public void getFlipkartPage() {
		FlipkartPage.openFlipkartPage();
	}
	
	@Test(priority=4)
	public void getLoginPopup() {
		FlipkartPage.closeLoginPopup();
	}
	
	@Test(priority=5)
	public void getWindowsAcPage() {
		FlipkartPage.navigateOnWindowsAcPage();
	}
	
	@Test(priority=6)
	public void getCheckbox() {
		FlipkartPage.clickOnAddtoCompareCheckbox();
	}
	
	@Test(priority=7)
	public void getAnotherProduct() {
		FlipkartPage.addAnotherProduct();
	}
	
	@Test(priority=8)
	public void getNameAndPrice() {
		FlipkartPage.printNameAndPrice();
	}
	
	@Test(priority=9)
	public void getProductsInCart() {
		FlipkartPage.addProductInCart();
	}
	
	@Test(priority=10)
	public void getAvailability() {
		FlipkartPage.checkAvailability();
	}
	
	@Test(priority=11)
	public void getAvailabilityOnChangePincode() {
		FlipkartPage.checkAvailabilityOnChangePincode();
	}

}
