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

public class Free_Magento_pages extends BaseClass {
	private WebElement select_ppt;
	private String verify_ppt_page;
	private WebElement free_Stuff;
	private WebElement free_ppt;
	private int product_size;
	private WebElement page_number;
	WebElement business_ppt;
	private String pageNumber;

	@Given("^User is on Home Pagei$")
	public void user_is_on_Home_Pagei() throws Throwable {
		Thread.sleep(3000);
		driver.get(AppURL);
		Thread.sleep(3000);
		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
	}

	@Then("^click on Free PPts under Free Stuff$")
	public void click_on_Free_PPts_under_Free_Stuff() throws Throwable {
		// click on free stuff without login
		try {
			Thread.sleep(3000);
			free_Stuff = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//li[@class='menu-item has-sub-class']//a[@title = 'Free Stuff']")));
			Actions action = new Actions(driver);
			action.moveToElement(free_Stuff).perform();
			Thread.sleep(3000);
			free_ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Free Samples']")));
			action.moveToElement(free_ppt).click().perform();
		} catch (NoSuchElementException e) {

		}

	}

	@Then("^mouse hover on any of one free ppt and verify the pop-up$")
	public void mouse_hover_on_any_of_one_free_ppt_and_verify_the_pop_up() throws Throwable {
		// select ppt under free stuff
		try {
			Thread.sleep(3000);
			select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//img[@title='Circular flow of process 4 stages free powerpoint templates slides']")));
			Actions action = new Actions(driver);
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			action.moveToElement(select_ppt).perform();
			Thread.sleep(3000);

			// to verify the pop-up
			String display = driver.findElement(By.xpath("//div[@id = 'imgtip15977']")).getCssValue("display");
			Thread.sleep(3000);
			System.out.println("display= " + display);

			Assert.assertTrue("pop-up is not visible", display.equals("block")); // if block - visible if none - not
																					// visible
		} catch (NoSuchElementException e) {

		}

	}

	@Then("^click on any of page number and verify the listing page for free ppts$")
	public void click_on_any_of_page_number_and_verify_the_listing_page_for_free_ppts() throws Throwable {
		Thread.sleep(3000);
		// click on 2nd page
		page_number = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[3]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[2]")));
		pageNumber = page_number.getText();
		page_number.click();

		List<WebElement> productSize = driver
				.findElements(By.xpath("//div[@class = 'container listing-container']//ol//li"));

		System.out.println("Total product on " + pageNumber + "rd page = " + productSize.size());

		product_size = productSize.size();
		Assert.assertTrue("No product is displayed", product_size > 0);

		// code for infinite scrolling

		/*
		 * for (int second = 0;; second++) { if (second >= 30) { break; }
		 * js.executeScript("window.scrollBy(0,1200)", ""); Thread.sleep(3000); String
		 * url = driver.getCurrentUrl(); String URL =
		 * "https://www.slideteam.net/share-and-download-products/?p=2"; if
		 * (URL.equals(url)) { Thread.sleep(10000); select_ppt =
		 * wait.until(ExpectedConditions .elementToBeClickable(By.
		 * xpath("//img[@title='Marketing process chart powerpoint icon cc']")));
		 * select_ppt.click(); break; }
		 * 
		 * }
		 */

	}

	@Then("^click on any of one ppt under free ppts$")
	public void click_on_any_of_one_ppt_under_free_ppts() throws Throwable {
		try {
			Thread.sleep(3000);
			select_ppt = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[4]/div[1]/ol[1]/li[1]/div[1]/a[1]/img[1]")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^verify the navigation on correct ppt page$")
	public void verify_the_navigation_on_correct_ppt_page() throws Throwable {
		try {
			Thread.sleep(5000);
			verify_ppt_page = wait
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//button[normalize-space()='Download this presentation']")))
					.getText();
			Assert.assertTrue("user is not on corect page", verify_ppt_page.contains("Download this presentation"));
		} catch (NoSuchElementException e) {

		}

	}

	@Then("^click on Free Business PPTs under Free stuff$")
	public void click_on_Free_Business_PPTs_under_Free_stuff() throws Throwable {
		// click on free Business PPts without login
		try {
			Thread.sleep(4000);
			free_Stuff = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[@class='menu-link'][normalize-space()='Free Stuff']")));
			Actions action = new Actions(driver);
			action.moveToElement(free_Stuff).perform();
			Thread.sleep(2000);
			business_ppt = BaseClass.elementToBeClickable(By.xpath("//a[@title='Free Business PPTs']"));
			Thread.sleep(1000);
			action.moveToElement(business_ppt).click().perform();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^mouse hover on any of one ppt and verify the pop-up$")
	public void mouse_hover_on_any_of_one_ppt_and_verify_the_pop_up() throws Throwable {
		try {
			Thread.sleep(4000);
			select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//img[@title='3d puzzle pieces in line powerpoint presentation slides']")));
			Actions action = new Actions(driver);
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			action.moveToElement(select_ppt).perform();
			Thread.sleep(4000);

			// to verify the pop-up
			String display = driver.findElement(By.xpath("//div[@id = 'imgtip13427']")).getCssValue("display");
			System.out.println("display= " + display);

			Assert.assertTrue("pop-up is not visible", display.equals("block"));

		} catch (NoSuchElementException e) {

		}

	}

	@Then("^click on any of page numberi$")
	public void click_on_any_of_page_numberi() throws Throwable {
		Thread.sleep(3000);
		// click on 4th page
		page_number = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[3]//div[1]//div[1]//div[1]//ul[1]//li[4]//a[1]//span[2]")));
		pageNumber = page_number.getText();
		page_number.click();

		List<WebElement> productSize = driver
				.findElements(By.xpath("//div[@class = 'container listing-container']//ol//li"));

		System.out.println("Total product on " + pageNumber + "th page = " + productSize.size());

		product_size = productSize.size();
		Assert.assertTrue("No product is displayed", product_size > 0);

		// code for infinite scrolling, clicking on page 2

		/*
		 * for (int second = 0;; second++) { if (second >= 30) { break; }
		 * js.executeScript("window.scrollBy(0,1200)", ""); Thread.sleep(3000); String
		 * url = driver.getCurrentUrl(); String URL =
		 * "https://www.slideteam.net/free-business-powerpoint-templates/?p=2"; if
		 * (URL.equals(url)) { Thread.sleep(9000); select_ppt = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.
		 * xpath("//img[@title='Belarus map with flag colour']"))); select_ppt.click();
		 * break; }
		 * 
		 * }
		 */
	}

	@Then("^click on any of one ppts$")
	public void click_on_any_of_one_ppts() throws Throwable {
		Thread.sleep(3000);
		select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//img[@title='Recast mortgage payment ppt powerpoint presentation summary layout cpb']")));
		js.executeScript("arguments[0].scrollIntoView();", select_ppt);
		select_ppt.click();
	}

	@Then("^verify the navigation on cottect ppt page$")
	public void verify_the_navigation_on_cottect_ppt_page() throws Throwable {
		Thread.sleep(4000);
		verify_ppt_page = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='product-gallery-title']")))
				.getText();
		Assert.assertTrue("user is not on corect page",
				verify_ppt_page.contains("Recast mortgage payment ppt powerpoint presentation summary layout cpb"));
	}

	@Then("^Click on signin page$")
	public void click_on_signin_page() throws Throwable {
		Thread.sleep(4000);
		WebElement sign_in = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign In']")));
		sign_in.click();
	}

	@Then("^Enter username \"([^\"]*)\" and passwordi \"([^\"]*)\"$")
	public void enter_username_and_passwordi(String username, String password) throws Throwable {
		Thread.sleep(4000);
		try {
			WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
			email.sendKeys(username);

			WebElement password_field = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")));
			password_field.sendKeys(password);
			Thread.sleep(4000);

			WebElement login_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Login']")));
			login_btn.click();
			Thread.sleep(4000);
			if (!driver.findElements(By.xpath("//div[@class='login-attempt-popup']")).isEmpty()) {
				WebElement approve = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirm-approve']")));
				approve.click();
			}
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Click on Free Ppts under Free Stuff$")
	public void click_on_Free_Ppts_under_Free_Stuff() throws Throwable {
		// click on free stuff after login
		try {
			Thread.sleep(4000);
			free_Stuff = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//li[@class='menu-item has-sub-class']//a[@title = 'Free Stuff']")));
			Actions action = new Actions(driver);
			action.moveToElement(free_Stuff).perform();
			Thread.sleep(3000);
			free_ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Free Samples']")));
			action.moveToElement(free_ppt).click().perform();
			Thread.sleep(4000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Mouse Hover on any of one free ppt and verify the pop-up$")
	public void mouse_Hover_on_any_of_one_free_ppt_and_verify_the_pop_up() throws Throwable {
		try {
			select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//img[@title='Circular flow of process 4 stages free powerpoint templates slides']")));
			Actions action = new Actions(driver);
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			action.moveToElement(select_ppt).perform();

			Thread.sleep(4000);
			// to verify the pop-up
			String display = driver.findElement(By.xpath("//div[@id = 'imgtip15977']")).getCssValue("display");
			System.out.println("display= " + display);

			Assert.assertTrue("pop-up is not visible", display.equals("block")); // if block - visible if none - not
																					// visible
		} catch (NoSuchElementException e) {

		}

	}

	@Then("^Click on any of page number and verify the listing page for free ppts$")
	public void Click_on_any_of_page_number_and_verify_the_listing_page_for_free_ppts() throws Throwable {
		try {
			Thread.sleep(3000);
			// click on 2rd page
			page_number = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[3]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[2]")));
			pageNumber = page_number.getText();
			page_number.click();

			List<WebElement> productSize = driver
					.findElements(By.xpath("//div[@class = 'container listing-container']//ol//li"));

			System.out.println("Total product on " + pageNumber + "nd  page = " + productSize.size());

			product_size = productSize.size();
			Assert.assertTrue("No product is displayed", product_size > 0);
		} catch (NoSuchElementException e) {

		}

		// code for infinite scrolling

		/*
		 * for (int second = 0;; second++) { if (second >= 30) { break; }
		 * js.executeScript("window.scrollBy(0,1200)", ""); Thread.sleep(3000); String
		 * url = driver.getCurrentUrl(); String URL =
		 * "https://www.slideteam.net/share-and-download-products/?p=2"; if
		 * (URL.equals(url)) { Thread.sleep(10000); select_ppt =
		 * wait.until(ExpectedConditions .elementToBeClickable(By.
		 * xpath("//img[@title='Branding and marketing powerpoint icon c']")));
		 * select_ppt.click(); break; }
		 * 
		 * }
		 */
	}

	@Then("^Click on any of one ppt under free ppts$")
	public void Click_on_any_of_one_ppt_under_free_ppts() throws Throwable {
		try {
			Thread.sleep(3000);
			select_ppt = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[4]/div[1]/ol[1]/li[1]/div[1]/a[1]/img[1]")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Verify the navigation on correct ppt page$")
	public void Verify_the_navigation_on_correct_ppt_page() throws Throwable {
		try {
			Thread.sleep(4000);
			verify_ppt_page = wait
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//button[normalize-space()='Download this presentation']")))
					.getText();
			Assert.assertTrue("user is not on corect page", verify_ppt_page.contains("Download this presentation"));
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Click on Free Business PPTs under Free stuff$")
	public void Click_on_Free_Business_PPTs_under_Free_stuff() throws Throwable {
		// click on free Business PPTs after login
		try {
			Thread.sleep(4000);
			free_Stuff = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//li[@class='menu-item has-sub-class']//a[@title = 'Free Stuff']")));
			Actions action = new Actions(driver);
			action.moveToElement(free_Stuff).perform();
			Thread.sleep(4000);
			business_ppt = BaseClass.elementToBeClickable(By.xpath("//a[@title='Free Business PPTs']"));
			action.moveToElement(business_ppt).click().perform();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Mouse hover on any of one ppt and verify the pop-up$")
	public void Mouse_hover_on_any_of_one_ppt_and_verify_the_pop_up() throws Throwable {
		try {
			select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//img[@title='3d puzzle pieces in line powerpoint presentation slides']")));
			Actions action = new Actions(driver);
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			action.moveToElement(select_ppt).perform();

		} catch (NoSuchElementException e) {

		}
		Thread.sleep(3000);
		// to verify the pop-up
		String display = driver.findElement(By.xpath("//div[@id = 'imgtip13427']")).getCssValue("display");
		System.out.println("display= " + display);

		Assert.assertTrue("pop-up is not visible", display.equals("block"));
	}

	@Then("^Click on any of page numberii$")
	public void click_on_any_of_page_numberii() throws Throwable {
		try {
			Thread.sleep(3000);
			// click on 5th page
			page_number = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[3]//div[1]//div[1]//div[1]//ul[1]//li[5]//a[1]//span[2]")));
			pageNumber = page_number.getText();
			page_number.click();

			List<WebElement> productSize = driver
					.findElements(By.xpath("//div[@class = 'container listing-container']//ol//li"));

			System.out.println("Total product on " + pageNumber + "th page = " + productSize.size());

			product_size = productSize.size();
			Assert.assertTrue("No product is displayed", product_size > 0);
		} catch (NoSuchElementException e) {

		}

		// code for infinite scrolling, clicking on page 2

		/*
		 * for (int second = 0;; second++) { if (second >= 30) { break; }
		 * js.executeScript("window.scrollBy(0,1200)", ""); Thread.sleep(3000); String
		 * url = driver.getCurrentUrl(); String URL =
		 * "https://www.slideteam.net/free-business-powerpoint-templates/?p=2"; if
		 * (URL.equals(url)) { Thread.sleep(10000); select_ppt =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//img[@title='Belarus map with flag colour']"))); select_ppt.click();
		 * break; }
		 * 
		 * }
		 */
	}

	@Then("^Click on any of one ppts$")
	public void Click_on_any_of_one_ppts() throws Throwable {
		try {
			Thread.sleep(3000);
			select_ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//img[@title='Convenience services examples ppt powerpoint presentation gallery slide cpb']")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Verify the navigation on cottect ppt pageii$")
	public void verify_the_navigation_on_cottect_ppt_pageii() throws Throwable {
		try {
			Thread.sleep(4000);
			verify_ppt_page = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='product-gallery-title']")))
					.getText();
			Assert.assertTrue("user is not on corect page", verify_ppt_page
					.contains("Convenience services examples ppt powerpoint presentation gallery slide cpb"));

			Thread.sleep(4000);
		} catch (NoSuchElementException e1) {

		}
		// sign out from the application
		try {
			Thread.sleep(4000);
			WebElement sign_Out = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out")));
			Thread.sleep(3000);
			sign_Out.click();
			Thread.sleep(5000);
		} catch (NoSuchElementException e) {

		}

		// verify the message after signout
		String verifySignOutMessage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@class='base']"))).getText();

		Assert.assertTrue("user is not logout from the application",
				verifySignOutMessage.contains("YOU ARE NOW LOGGED OUT"));
	}

}
