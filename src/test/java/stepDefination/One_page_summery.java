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

public class One_page_summery extends BaseClass {
	private WebElement page_number;
	private String pageNumber;
	private int product_size;

	@Given("^User is on Home Pages$")
	public void user_is_on_Home_Pages() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");
	}

	@Then("^Click on the one page summery text in left navigation bar$")
	public void click_on_the_one_page_summery_text_in_left_navigation_bar() throws Throwable {
		WebElement one_Page_Summary = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("One Pagers")));
		one_Page_Summary.click();
	}

	@Then("^Mouse hover on any of A(\\d+) size page and verify the pop-up$")
	public void mouse_hover_on_any_of_A_size_page_and_verify_the_pop_up(int arg1) throws Throwable {
		try {
			Thread.sleep(3000);
			WebElement select_A4_page = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
					"img[title='Business executive summary report presentation report infographic ppt pdf document']")));
			Actions action = new Actions(driver);
			js.executeScript("arguments[0].scrollIntoView();", select_A4_page);
			action.moveToElement(select_A4_page).perform();
			Thread.sleep(4000);

			// to verify the pop-up
			String display = driver.findElement(By.xpath("//div[@id = 'imgtip11']")).getCssValue("display");
			System.out.println("display= " + display);

			Assert.assertTrue("pop-up is not visible", display.equals("block")); // if block - visible if none - not
																					// visible
		} catch (NoSuchElementException e) {

		}

	}

	@Then("^Click on pagination number$")
	public void click_on_pagination_number() throws Throwable {
		Thread.sleep(4000);
		// click on 2nd page
		page_number = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='resume-toolbar bottom']//li[2]//a[1]")));
		pageNumber = page_number.getText();
		page_number.click();

		List<WebElement> productSize = driver.findElements(By.xpath("//div[@class='conatiner']//ul/li"));

		System.out.println("Total product on " + pageNumber + "nd page = " + productSize.size());

		product_size = productSize.size();
		Assert.assertTrue("No product is displayed", product_size > 0);
	}

	@Then("^Click on any of PPT$")
	public void click_on_any_of_PPT() throws Throwable {

		try {
			Thread.sleep(4000);
			WebElement select_ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='conatiner']//ul/li[3]")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^Verify the page$")
	public void verify_the_page() throws Throwable {

		try {
			Thread.sleep(4000);
			String verify_Download_button = BaseClass.precenceOfElement(By.xpath("//button[@id='clicking']")).getText();
			Assert.assertTrue("user is not on corect page", verify_Download_button.contains("Download This Document"));
		} catch (NoSuchElementException e) {

		}

	}

}
