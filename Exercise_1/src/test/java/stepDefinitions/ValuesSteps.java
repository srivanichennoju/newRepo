package stepDefinitions;

import java.text.ParseException;

import org.junit.After;
import org.openqa.selenium.WebDriver;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import pages.ValuesPage;

public class ValuesSteps extends BaseTest {
	
	public WebDriver driver;
	ValuesPage valuespage = new ValuesPage(driver);
	
	@Given("Launch The URL in Chrome")
	public void launch_the_url_in_chrome() {
	  
		initializeChromeBrowser();
		
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
	  
		closeBrowser();
		
	}
	
	@And("Verify the Number of Values")
	public void verify_the_number_of_values() {

		valuespage.VerifyRightCountValues();
	}
	
	@And("Verify the values are greater than zero")
	public void verify_the_values_are_greater_than_zero() {

		valuespage.VerifyValuesGreateThanZero();
	}
	
	@And("Verify the total balance is correct")
	public void verify_the_total_balance_is_correct() {

		valuespage.TotalBalanceIsCorrectBasedOnValues();
	}
	
	@And("Verify the values are formatted as Currencies")
	public void verify_the_values_are_formatted_as_currencies() throws ParseException {

		valuespage.VerifyingValuesFormattedCorrectly();
	}
	
	@And("Verify the total balance matches sum of values")
	public void verify_the_total_balance_matches_sum_of_values() throws ParseException {

		valuespage.TotalBalanceMatchesSumOftheValues();
	}

}
