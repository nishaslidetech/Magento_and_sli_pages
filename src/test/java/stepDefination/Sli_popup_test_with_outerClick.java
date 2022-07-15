package stepDefination;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SetUpClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Sli_popup_test_with_outerClick extends BaseClass {
	private String pop_up_Value;
	private String pop_up_visible = "block";
	private String pop_up_not_visible = "none";
	private WebElement search_field;

	@Given("^Go to Home page$")
	public void go_to_Home_page() throws Throwable {
		log.info("It's opening the website URL");

		driver.get(AppURL);
		BaseClass.ClearBrowserCache();
	}

	@Then("^Enter \"([^\"]*)\" data in search field$")
	public void enter_data_in_search_field(String text) throws Throwable {
		try {
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.sendKeys(text);
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^press the outer click$")
	public void press_the_outer_click() throws Throwable {
		try {
			Thread.sleep(2000);
			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");

			System.out.println("pop-up value before clicking outer click1 =  " + pop_up_Value);
			if (pop_up_Value.equals(pop_up_visible)) {

				Actions action = new Actions(driver);
				action.moveByOffset(0, 83).click().perform();
			} else {

				System.out.println("pop-up is not displayed before clicking outer click1 " + pop_up_Value);
				assertTrue(pop_up_Value.equals(pop_up_visible));
			}
		} catch (NoSuchElementException e) {
		}
	}

	@Then("^verify the popup is visible or not\\?$")
	public void verify_the_popup_is_visible_or_not() throws Throwable {
		try {
			Thread.sleep(3000);
			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is displayed after clicking outer click1 " + pop_up_Value);
			assertTrue(pop_up_Value.equals(pop_up_not_visible));
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^open Sli listing page and verify the popup$")
	public void open_Sli_listing_page_and_verify_the_popup() throws Throwable {
		try {
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			Thread.sleep(2000);

			search_field.sendKeys(Keys.CONTROL + "a");
			search_field.sendKeys(Keys.DELETE);
			Thread.sleep(3000);

			Thread.sleep(2000);

			search_field.sendKeys("HR");
			Thread.sleep(4000);

			// click on "hr report" in left navigation bar

			WebElement hr_Report = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-suggested-term='hr report']")));
			hr_Report.click();
			Thread.sleep(3000);

			// Clear the search field and enter "Management" on sli listing page
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.sendKeys(Keys.CONTROL + "a");
			search_field.sendKeys(Keys.DELETE);
			Thread.sleep(3000);

			search_field.sendKeys("Software");
			Thread.sleep(4000);

			// Pressed outside click after pop-up is visible else script got failed

			pop_up_Value = driver.findElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			Thread.sleep(2000);
			System.out.println("pop-up value before clicking outer click2 =  " + pop_up_Value);
			if (pop_up_Value.equals(pop_up_visible)) {

				Actions action = new Actions(driver);
				action.moveByOffset(0, 83).click().perform();
				Thread.sleep(2000);

			} else {

				System.out.println("pop-up is not displayed before clicking outer click2 " + pop_up_Value);
				assertTrue(pop_up_Value.equals(pop_up_visible));
			}

			// verify the pop-up should not visible after clicking outside click

			Thread.sleep(3000);
			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is displayed after clicking outer click2 " + pop_up_Value);
			assertTrue(pop_up_Value.equals(pop_up_not_visible));
			Thread.sleep(2000);

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Click on Signin button$")
	public void click_on_Signin_button() throws Throwable {
		try {
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.sendKeys(Keys.CONTROL + "a");
			search_field.sendKeys(Keys.DELETE);
			Thread.sleep(3000);

			Thread.sleep(2000);
			WebElement sign_In = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign In']")));
			js.executeScript("arguments[0].click();", sign_In);
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Enter free valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void enter_free_valid_username_and_password(String username, String Password) throws Throwable {
		try {
			WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
			email.sendKeys(username);
			WebElement password = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")));
			password.sendKeys(Password);
			WebElement login_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Login']")));
			login_btn.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Enter \"([^\"]*)\" data in Search fields$")
	public void enter_data_in_Search_fields(String text1) throws Throwable {
		try {
			Thread.sleep(3000);
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.sendKeys(text1);
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
	}

	@Then("^Press the outerside the pop-up$")
	public void press_the_outerside_the_pop_up() throws Throwable {
		try {
			Thread.sleep(3000);
			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is not displayed before clicking outer click3 " + pop_up_Value);
			if (pop_up_Value.equals(pop_up_visible)) {

				Actions action = new Actions(driver);
				action.moveByOffset(0, 83).click().perform();
			} else {

				System.out.println("pop-up is not displayed before clicking outer click3 " + pop_up_Value);
				// condition failed with none and block value
				assertTrue(pop_up_Value.equals(pop_up_visible));
			}
		} catch (NoSuchElementException e) {
		}
	}

	@Then("^verify the Popupi$")
	public void verify_the_Popupi() throws Throwable {
		try {
			Thread.sleep(3000);
			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is displayed after clicking outer click3 " + pop_up_Value);
			assertTrue(pop_up_Value.equals(pop_up_not_visible));

			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.sendKeys(Keys.CONTROL + "a");
			search_field.sendKeys(Keys.DELETE);
			Thread.sleep(3000);

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Open Sli listing pages and verify the pop-up$")
	public void open_Sli_listing_pages_and_verify_the_pop_up() throws Throwable {
		try {
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			Thread.sleep(2000);

			search_field.sendKeys(Keys.CONTROL + "a");
			search_field.sendKeys(Keys.DELETE);
			Thread.sleep(3000);

			Thread.sleep(2000);

			search_field.sendKeys("Management");
			Thread.sleep(2000);

			// click on "hr report" in left navigation bar

			WebElement change_Management_training_plans = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//a[@data-suggested-term='change management']//span[@class='highlight'][normalize-space()='management']")));
			change_Management_training_plans.click();
			System.out.println();

			// Clear the search field and enter "Management" on sli listing page
			Thread.sleep(2000);
			search_field = BaseClass.elementToBeClickable(By.xpath("//input[@id='search']"));
			search_field.sendKeys(Keys.CONTROL + "a");
			search_field.sendKeys(Keys.DELETE);
			Thread.sleep(3000);

			search_field.sendKeys("HR");
			Thread.sleep(4000);

			// Pressed ESC key after pop-up is visible else script got failed

			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up value before clicking outer click4 =  " + pop_up_Value);
			if (pop_up_Value.equals(pop_up_visible)) {

				Actions action = new Actions(driver);
				action.moveByOffset(0, 83).click().perform();
				Thread.sleep(2000);

			} else {

				System.out.println("pop-up is not displayed before clicking outer click4 " + pop_up_Value);
				assertTrue(pop_up_Value.equals(pop_up_visible));
			}

			// verify the pop-up should not visible after pressing Escape key

			Thread.sleep(3000);
			pop_up_Value = driver.findElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is displayed after clicking outer click4 " + pop_up_Value);
			assertTrue(pop_up_Value.equals(pop_up_not_visible));
			Thread.sleep(4000);

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Click on the sign out button and verify the page$")
	public void click_on_the_sign_out_button_and_verify_the_page() throws Throwable {
		try {
			// click on sign out button
			driver.navigate().refresh();
			WebElement sign_Out = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out")));
			js.executeScript("arguments[0].click();", sign_Out);
			Thread.sleep(3000);

			// verify the message after sign out
			String verification_Message = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@class='base']"))).getText();

			System.out.println("verification_Message = " + verification_Message);
			Assert.assertTrue("user is not sign out from apploication",
					verification_Message.contains("YOU ARE NOW LOGGED OUT"));
		} catch (NoSuchElementException e) {

		}
	}
}
