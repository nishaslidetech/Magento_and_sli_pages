package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SetUpClass.BaseClass;
import io.cucumber.java.en.Then;

public class BlogMultilanguageCheck extends BaseClass {
	WebElement dropDown;
	WebElement selectLanguage;
	String expextedURL;

	@Then("click on Blog button")
	public void click_on_blog_button() throws InterruptedException {
		try {
			WebElement blog = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Blog']")));
			blog.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("select language from dropdown list and verify the url")
	public void select_language_from_dropdown_list() throws InterruptedException {

		WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='langSel']")));
		dropDown.click();

		WebElement selectLanguage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='German']")));
		selectLanguage.click();
		String expextedURL = "https://www.slideteam.net/blog?lang=german";
		// System.out.println("URL = " + driver.getCurrentUrl());
		Assert.assertEquals("Multilanguage", expextedURL, driver.getCurrentUrl());

		// select french
		Thread.sleep(1000);
		dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='langSel']")));
		dropDown.click();

		selectLanguage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='French']")));
		selectLanguage.click();
		expextedURL = "https://www.slideteam.net/blog?lang=french";
		// System.out.println("URL = " + driver.getCurrentUrl());
		Assert.assertEquals("Multilanguage", expextedURL, driver.getCurrentUrl());

		// select Portuguse
		Thread.sleep(1000);
		dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='langSel']")));
		dropDown.click();

		selectLanguage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='Portuguese']")));
		selectLanguage.click();
		expextedURL = "https://www.slideteam.net/blog?lang=portuguese";
		// System.out.println("URL = " + driver.getCurrentUrl());
		Assert.assertEquals("Multilanguage", expextedURL, driver.getCurrentUrl());

		// selec Arabic
		Thread.sleep(1000);
		dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='langSel']")));
		dropDown.click();

		selectLanguage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='Arabic']")));
		selectLanguage.click();
		expextedURL = "https://www.slideteam.net/blog?lang=arabic";
		// System.out.println("URL = " + driver.getCurrentUrl());
		Assert.assertEquals("Multilanguage", expextedURL, driver.getCurrentUrl());
	}

}
