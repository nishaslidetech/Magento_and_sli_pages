package stepDefination;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SetUpClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Paid_magento_pages extends BaseClass {
	private WebElement select_ppt;
	private String verify_ppt_page;

	private WebElement popular_Ppts;
	private int product_size;
	private WebElement page_number;
	WebElement business_ppt;
	private String pageNumber;

	@Given("^User is on Home Pageii$")
	public void user_is_on_Home_Pageii() throws Throwable {
		log.info("It's opening the website URL");
		Thread.sleep(2000);
		driver.get(AppURL);
		BaseClass.ClearBrowserCache();
	}

	@Then("^click on popular ppts$")
	public void click_on_popular_ppts() throws Throwable {
		// click on Popular PPTs without login
		try {
			popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Popular PPTs")));
			popular_Ppts.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^mouse hover on any of one ppt$")
	public void mouse_hover_on_any_of_one_ppt() throws Throwable {

		try {
			select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//img[@title='Change Management Powerpoint Presentation Slides']")));
			Actions action = new Actions(driver);
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			action.moveToElement(select_ppt).perform();

		} catch (NoSuchElementException e) {

		}

	}

	@Then("^verify the displayed pop-up is visible$")
	public void verify_the_displayed_pop_up_is_visible() throws Throwable {
		try {
			Thread.sleep(3000);
			String display = driver.findElement(By.xpath("//div[@id = 'imgtip97339']")).getCssValue("display");
			System.out.println("display= " + display);
			// if block - visible if none - not visible
			Assert.assertTrue("pop-up is not visible", display.equals("block"));

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on Any of page number and verify the popular ppts$")
	public void click_on_Any_of_page_number_and_verify_the_popular_ppts() throws Throwable {
		try {
			Thread.sleep(3000);
			// click on 3rd page
			page_number = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[3]//div[1]//div[1]//div[1]//ul[1]//li[3]//a[1]//span[2]")));
			pageNumber = page_number.getText();
			page_number.click();

			List<WebElement> productSize = driver
					.findElements(By.xpath("//div[@class = 'container listing-container']//ol//li"));

			System.out.println("Total product on " + pageNumber + "rd page = " + productSize.size());

			product_size = productSize.size();
			Assert.assertTrue("No product is displayed", product_size > 0);
		} catch (NoSuchElementException e) {

		}

		// code for infinite scrolling
		/*
		 * for (int second = 0;; second++) { if (second >= 30) { break; }
		 * js.executeScript("window.scrollBy(0,1200)", ""); Thread.sleep(3000); String
		 * url = driver.getCurrentUrl(); String URL =
		 * "https://www.slideteam.net/professional-powerpoint-templates?p=2"; if
		 * (URL.equals(url)) { Thread.sleep(10000);
		 * 
		 * select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
		 * By.xpath("//div[4]/div[2]/ol[1]/li[1]/div[1]/a[1]/img[1]")));
		 * select_ppt.click(); break; }
		 * 
		 * }
		 */

	}

	@Then("^click on any of one Ppt$")
	public void click_on_any_of_one_Ppt() throws Throwable {
		try {
			Thread.sleep(3000);
			select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//img[@title='Competitive analysis template 5 comparison table powerpoint guide']")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^verify the user will navigation on cottect ppt page$")
	public void verify_the_user_will_navigation_on_cottect_ppt_page() throws Throwable {
		try {
			Thread.sleep(3000);
			verify_ppt_page = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='product-gallery-title']")))
					.getText();
			Assert.assertTrue("user is not on corect page",
					verify_ppt_page.contains("Competitive analysis template 5 comparison table powerpoint guide"));
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Click on signin pageii$")
	public void click_on_signin_pageii() throws Throwable {
		try {
			Thread.sleep(3000);
			WebElement sign_in = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign In']")));
			sign_in.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Enter username \"([^\"]*)\" and passwordii \"([^\"]*)\"$")
	public void enter_username_and_passwordii(String username, String password) throws Throwable {
		try {

			Thread.sleep(3000);
			WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
			email.sendKeys(username);
			Thread.sleep(2000);
			WebElement password_field = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")));
			password_field.sendKeys(password);
			Thread.sleep(3000);
			WebElement login_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Login']")));
			login_btn.click();
			Thread.sleep(5000);
			if (!driver.findElements(By.xpath("//div[@class='login-attempt-popup']")).isEmpty()) {
				WebElement approve = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirm-approve']")));
				approve.click();
				Thread.sleep(5000);
			}
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Click on popular ppts$")
	public void Click_on_popular_ppts() throws Throwable {
		// click on Popular ppts after login
		try {
			driver.navigate().refresh();
			Thread.sleep(3000);
			popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Popular PPTs")));
			popular_Ppts.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Mouse hover on any of one ppt$")
	public void Mouse_hover_on_any_of_one_ppt() throws Throwable {

		try {
			select_ppt = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[4]/div[1]/ol[1]/li[1]/div[1]/a[1]/img[1]")));
			Actions action = new Actions(driver);
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			action.moveToElement(select_ppt).perform();

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Verify the displayed pop-up is visibleii$")
	public void verify_the_displayed_pop_up_is_visibleii() throws Throwable {
		try {
			Thread.sleep(3000);
			String display = driver.findElement(By.xpath("//div[@id = 'imgtip141385']")).getCssValue("display");
			System.out.println("display= " + display);
			// if block - visible if none - not visible
			Assert.assertTrue("pop-up is not visible", display.equals("block"));

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Click on any of page number$")
	public void click_on_any_of_page_number() throws Throwable {
		// click on 4th page
		try {
			page_number = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[3]//div[1]//div[1]//div[1]//ul[1]//li[4]//a[1]//span[2]")));
			pageNumber = page_number.getText();
			page_number.click();

			List<WebElement> productSize = driver
					.findElements(By.xpath("//div[@class = 'container listing-container']//ol//li"));

			System.out.println("Total product on " + pageNumber + "th page = " + productSize.size());

			product_size = productSize.size();
			Assert.assertTrue("No product is displayed", product_size > 0);
		} catch (NoSuchElementException e) {

		}

		// code for infinite scrolling

		/*
		 * for (int second = 0;; second++) { if (second >= 30) { break; }
		 * js.executeScript("window.scrollBy(0,1200)", ""); Thread.sleep(3000); String
		 * url = driver.getCurrentUrl(); String URL =
		 * "https://www.slideteam.net/professional-powerpoint-templates?p=2"; if
		 * (URL.equals(url)) { Thread.sleep(10000); select_ppt =
		 * wait.until(ExpectedConditions.elementToBeClickable(
		 * By.xpath("//div[4]/div[2]/ol[1]/li[13]/div[1]/a[1]/img[1]")));
		 * select_ppt.click(); break; }
		 * 
		 * }
		 */
	}

	@Then("^Click on any of ppt$")
	public void click_on_any_of_ppt() throws Throwable {

		try {
			Thread.sleep(3000);
			select_ppt = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[4]/div[1]/ol[1]/li[6]/div[1]/a[1]/img[1]")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Verify the navigation on cottect ppt page$")
	public void verify_the_navigation_on_cottect_ppt_page() throws Throwable {
		try {
			Thread.sleep(3000);
			verify_ppt_page = wait
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//button[normalize-space()='Download this presentation']")))
					.getText();
			Assert.assertTrue("user is not on corect page", verify_ppt_page.contains("Download this presentation"));
			Thread.sleep(2000);
		} catch (NoSuchElementException e1) {

		}

		// sign out from the application
		try {
			Thread.sleep(2000);
			WebElement sign_Out = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out")));
			sign_Out.click();
			Thread.sleep(4000);
		} catch (NoSuchElementException e) {

		}

		// verify the message after signout
		String verifySignOutMessage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@class='base']"))).getText();

		Assert.assertTrue("user is not logout from the application",
				verifySignOutMessage.contains("YOU ARE NOW LOGGED OUT"));
	}

}
