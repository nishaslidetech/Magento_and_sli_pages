package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SetUpClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Emarsys_Widgets_Pages extends BaseClass {

	@Given("^Go to the Home page$")
	public void go_to_the_Home_page() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
	}

	@Then("^Scroll down the page$")
	public void scroll_down_the_page() throws Throwable {
		log.info("scroll down the page");
	}

	@Then("^select any of one PPT$")
	public void select_any_of_one_PPT() throws Throwable {
		Thread.sleep(3000);

		try {
			WebElement select_ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class = 'emarsys-currently-trending top-trending-slider clearfix'][1]//div//div//div//div//div[3]")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
		} catch (NoSuchElementException e) {

		}

	}

	@Then("^verify the download button$")
	public void verify_the_download_button() throws Throwable {
		// verify the download button
		try {
			Thread.sleep(4000);
			String verify_ppt_page = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Download this presentation']"))).getText();
			Assert.assertTrue("user is not on corect page", verify_ppt_page.contains("Download this presentation"));

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^navigate back to the home page$")
	public void navigate_back_to_the_home_page() throws Throwable {
		driver.navigate().back();
		Thread.sleep(4000);
	}

	@Then("^select select any of one ppt from second row$")
	public void select_select_any_of_one_ppt_from_second_row() throws Throwable {
		Thread.sleep(3000);

		try {
			WebElement select_ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class = 'emarsys-currently-trending top-trending-slider clearfix'][2]//div//div//div//div//div[4]")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^verify the download buttoni$")
	public void verify_the_download_buttoni() throws Throwable {
		// verify the download button
		try {
			Thread.sleep(4000);
			String verify_ppt_page = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Download this presentation']"))).getText();
			Assert.assertTrue("user is not on corect page", verify_ppt_page.contains("Download this presentation"));

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^navigate back to the home pagei$")
	public void navigate_back_to_the_home_pagei() throws Throwable {
		//navigates back to the home page.
		driver.navigate().back();
		Thread.sleep(4000);
	}

	@Then("^select select any of one ppt from third row$")
	public void select_select_any_of_one_ppt_from_third_row() throws Throwable {
		Thread.sleep(3000);

		try {
			WebElement select_ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class = 'emarsys-currently-trending top-trending-slider clearfix'][3]//div//div//div//div//div[5]")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^verify the download buttonii$")
	public void verify_the_download_buttonii() throws Throwable {
		// verify the download button whether is visible or not?
		try {
			Thread.sleep(4000);
			String verify_ppt_page = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Download this presentation']"))).getText();
			Assert.assertTrue("user is not on corect page", verify_ppt_page.contains("Download this presentation"));

		} catch (NoSuchElementException e) {

		}
	}

}
