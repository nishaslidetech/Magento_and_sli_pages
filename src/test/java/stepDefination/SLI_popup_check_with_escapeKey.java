package stepDefination;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SetUpClass.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SLI_popup_check_with_escapeKey extends BaseClass {
	private String pop_up_Value;
	private String pop_up_visible = "block";
	private String pop_up_not_visible = "none";
	private WebElement search_field;

	@Given("Now user is on Home Page")
	public void Now_user_is_on_home_page() throws Throwable {

		log.info("It's opening the website URL");
		Thread.sleep(2000);
		driver.get(AppURL);
		BaseClass.ClearBrowserCache();
	}

	@Then("Enter data in search field")
	public void enter_data_in_search_field() throws Throwable {

		try {
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.sendKeys("HR");
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("press escape key")
	public void press_escape_key() throws Throwable {

		try {
			Thread.sleep(2000);
			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");

			System.out.println("pop-up value before pressing Escape key1 =  " + pop_up_Value);
			if (pop_up_Value.equals(pop_up_visible)) {

				Actions action = new Actions(driver);
				action.sendKeys(Keys.ESCAPE).build().perform();
				/*
				 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_ESCAPE);
				 * robot.keyRelease(KeyEvent.VK_ESCAPE); Thread.sleep(1000);
				 * robot.keyPress(KeyEvent.VK_ESCAPE); robot.keyRelease(KeyEvent.VK_ESCAPE);
				 */
			} else {

				System.out.println("pop-up is not displayed before pressing Escape key1 " + pop_up_Value);
				assertTrue(pop_up_Value.equals(pop_up_visible));
			}
		} catch (NoSuchElementException e) {
		}
	}

	@Then("verify the pop-up")
	public void verify_the_pop_up() throws Throwable {
		try {
			Thread.sleep(3000);
			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is displayed after pressing Escape key1 " + pop_up_Value);
			assertTrue(pop_up_Value.equals(pop_up_not_visible));
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^open Sli listing page and verify the pop-up$")
	public void open_Sli_listing_page_and_verify_the_pop_up() throws Throwable {
		try {
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.clear();
			search_field.sendKeys("HR");
			Thread.sleep(4000);

			// click on "hr report" in left navigation bar

			WebElement hr_Report = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-suggested-term='hr report']")));
			hr_Report.click();
			Thread.sleep(3000);

			// Clear the search field and enter "Management" on sli listing page
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.clear();
			search_field.sendKeys("So");
			search_field.sendKeys("ftware");
			Thread.sleep(2000);

			// Pressed ESC key after pop-up is visible else script got failed

			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete'][2]"))
					.getCssValue("display");
			System.out.println("pop-up value before pressing Escape key2 =  " + pop_up_Value);
			if (pop_up_Value.equals(pop_up_visible)) {

				Actions action = new Actions(driver);
				action.sendKeys(Keys.ESCAPE).build().perform();
				/*
				 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_ESCAPE);
				 * robot.keyRelease(KeyEvent.VK_ESCAPE); Thread.sleep(1000);
				 * robot.keyPress(KeyEvent.VK_ESCAPE); robot.keyRelease(KeyEvent.VK_ESCAPE);
				 */
			} else {

				System.out.println("pop-up is not displayed before pressing Escape key2 " + pop_up_Value);
				assertTrue(pop_up_Value.equals(pop_up_visible));
			}

			// verify the pop-up should not visible after pressing Escape key

			Thread.sleep(3000);
			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete'][2]"))
					.getCssValue("display");
			System.out.println("pop-up is displayed after pressing Escape key2 " + pop_up_Value);
			assertTrue(pop_up_Value.equals(pop_up_not_visible));
			Thread.sleep(2000);

		} catch (NoSuchElementException e) {

		}
	}

	@Then("Click on Sign in button")
	public void click_on_sign_in_button() throws Throwable {
		try {
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.clear();
			Thread.sleep(2000);
			WebElement sign_In = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign In']")));
			js.executeScript("arguments[0].click();", sign_In);
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("Enter free valid username and password")
	public void enter_free_valid_username_and_password() throws Throwable {
		try {
			WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
			email.sendKeys("nishadhiman0027@gmail.com");
			WebElement password = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")));
			password.sendKeys("Qwerty@1");
			WebElement login_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Login']")));
			login_btn.click();
			Thread.sleep(2000);
			if (!driver.findElements(By.xpath("//div[@class='login-attempt-popup']")).isEmpty()) {
				WebElement approve = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirm-approve']")));
				approve.click();
			}
		} catch (NoSuchElementException e) {

		}
	}

	@Then("enter data in Search fields")
	public void enter_data_in_Search_fields() throws Throwable {
		try {
			Thread.sleep(3000);
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.sendKeys("Management");
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
	}

	@Then("Press Escape key")
	public void press_Escape_key() throws Throwable {
		try {
			Thread.sleep(3000);
			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is not displayed before pressing Escape key3 " + pop_up_Value);
			if (pop_up_Value.equals(pop_up_visible)) {

				Actions action = new Actions(driver);
				action.sendKeys(Keys.ESCAPE).build().perform();
				/*
				 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_ESCAPE);
				 * robot.keyRelease(KeyEvent.VK_ESCAPE); Thread.sleep(1000);
				 * robot.keyPress(KeyEvent.VK_ESCAPE); robot.keyRelease(KeyEvent.VK_ESCAPE);
				 */
			} else {

				System.out.println("pop-up is not displayed before pressing Escape key3 " + pop_up_Value);
				assertTrue(pop_up_Value.equals(pop_up_visible));
			}
		} catch (NoSuchElementException e) {
		}

	}

	@Then("verify the Pop-up")
	public void verify_the_Pop_up() throws Throwable {
		try {
			Thread.sleep(3000);
			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is displayed after pressing Escape key3 " + pop_up_Value);
			assertTrue(pop_up_Value.equals(pop_up_not_visible));

			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.clear();
			Thread.sleep(3000);

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^open Sli listing pages and verify the pop-up$")
	public void open_Sli_listing_pages_and_verify_the_pop_up() throws Throwable {
		try {
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.clear();
			search_field.sendKeys("Management");
			Thread.sleep(2000);

			// click on "hr report" in left navigation bar

			WebElement change_Management_training_plans = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//a[@data-suggested-term='change management training plan']//span[@class='highlight'][normalize-space()='management']")));
			change_Management_training_plans.click();
			System.out.println();

			// Clear the search field and enter "Management" on sli listing page
			Thread.sleep(2000);
			search_field = BaseClass.elementToBeClickable(By.xpath("//input[@id='search']"));
			search_field.clear();
			search_field.sendKeys("HR");
			Thread.sleep(4000);

			// Pressed ESC key after pop-up is visible else script got failed

			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete'][2]"))
					.getCssValue("display");
			System.out.println("pop-up value before pressing Escape key4 =  " + pop_up_Value);
			if (pop_up_Value.equals(pop_up_visible)) {

				Actions action = new Actions(driver);
				action.sendKeys(Keys.ESCAPE).build().perform();
				/*
				 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_ESCAPE);
				 * robot.keyRelease(KeyEvent.VK_ESCAPE); Thread.sleep(1000);
				 * robot.keyPress(KeyEvent.VK_ESCAPE); robot.keyRelease(KeyEvent.VK_ESCAPE);
				 */
			} else {

				System.out.println("pop-up is not displayed before pressing Escape key4 " + pop_up_Value);
				assertTrue(pop_up_Value.equals(pop_up_visible));
			}

			// verify the pop-up should not visible after pressing Escape key

			Thread.sleep(3000);
			pop_up_Value = BaseClass.precenceOfElement(By.xpath("//ul[@id='sli_autocomplete'][2]"))
					.getCssValue("display");
			System.out.println("pop-up is displayed after pressing Escape key4 " + pop_up_Value);
			assertTrue(pop_up_Value.equals(pop_up_not_visible));
			Thread.sleep(4000);

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Click on the sign out button$")
	public void click_on_the_sign_out_button() throws Throwable {

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
