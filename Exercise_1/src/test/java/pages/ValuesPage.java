package pages;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValuesPage {

	public WebDriver driver;

	public ValuesPage(WebDriver pdriver) {

		driver = pdriver;
		PageFactory.initElements(pdriver, this);

	}

	@FindBy(xpath = "//*[starts-with(@id,'lbl_val_')]")
	private List<WebElement> Values;

	@FindBy(xpath = "//*[starts-with(@id,'txt_val_')]")
	private List<WebElement> ValuesTxt;

	@FindBy(id = "lbl_val_1")
	private WebElement Value1;

	@FindBy(id = "lbl_val_2")
	private WebElement Value2;

	@FindBy(id = "lbl_val_3")
	private WebElement Value3;

	@FindBy(id = "lbl_val_4")
	private WebElement Value4;

	@FindBy(id = "lbl_val_5")
	private WebElement Value5;

	@FindBy(id = "txt_val_1")
	private WebElement Valuetxt1;

	@FindBy(id = "txt_val_2")
	private WebElement Valuetxt2;

	@FindBy(id = "txt_val_4")
	private WebElement Valuetxt3;

	@FindBy(id = "txt_val_5")
	private WebElement Valuetxt4;

	@FindBy(id = "txt_val_6")
	private WebElement Valuetxt5;

	@FindBy(id = "lbl_ttl_val")
	private WebElement TotalBalance;

	@FindBy(id = "txt_ttl_val")
	private WebElement TotalBalanceValue;

	public WebElement getValue1() {
		return Value1;
	}

	public void setValue1(WebElement value1) {
		Value1 = value1;
	}

	public WebElement getValue2() {
		return Value2;
	}

	public void setValue2(WebElement value2) {
		Value2 = value2;
	}

	public WebElement getValue3() {
		return Value3;
	}

	public void setValue3(WebElement value3) {
		Value3 = value3;
	}

	public WebElement getValue4() {
		return Value4;
	}

	public void setValue4(WebElement value4) {
		Value4 = value4;
	}

	public WebElement getValue5() {
		return Value5;
	}

	public void setValue5(WebElement value5) {
		Value5 = value5;
	}

	public WebElement getValuetxt1() {
		return Valuetxt1;
	}

	public void setValuetxt1(WebElement valuetxt1) {
		Valuetxt1 = valuetxt1;
	}

	public WebElement getValuetxt2() {
		return Valuetxt2;
	}

	public void setValuetxt2(WebElement valuetxt2) {
		Valuetxt2 = valuetxt2;
	}

	public WebElement getValuetxt3() {
		return Valuetxt3;
	}

	public void setValuetxt3(WebElement valuetxt3) {
		Valuetxt3 = valuetxt3;
	}

	public WebElement getValuetxt4() {
		return Valuetxt4;
	}

	public void setValuetxt4(WebElement valuetxt4) {
		Valuetxt4 = valuetxt4;
	}

	public WebElement getValuetxt5() {
		return Valuetxt5;
	}

	public void setValuetxt5(WebElement valuetxt5) {
		Valuetxt5 = valuetxt5;
	}

	public void VerifyRightCountValues() {

		Assert.assertEquals(Values.size(), ValuesTxt.size(), "Right Count of Values are displayed");

	}

	public void VerifyValuesGreateThanZero() {

		for (WebElement txt : ValuesTxt) {
			String amounttxt = txt.getText();
			double amount = Double.parseDouble(amounttxt);
			Assert.assertTrue(amount > 0);
		}

	}

	public void TotalBalanceIsCorrectBasedOnValues() {

		String TotalBalanceValueAmounttxt = TotalBalanceValue.getText();
		double TotalBalanceValueAmount = Double.parseDouble(TotalBalanceValueAmounttxt);
		String ValueTxt1Amounttxt = Valuetxt1.getText();
		double ValueTxt1Amount = Double.parseDouble(ValueTxt1Amounttxt);
		String ValueTxt2Amounttxt = Valuetxt1.getText();
		double ValueTxt2Amount = Double.parseDouble(ValueTxt2Amounttxt);
		String ValueTxt3Amounttxt = Valuetxt1.getText();
		double ValueTxt3Amount = Double.parseDouble(ValueTxt3Amounttxt);
		String ValueTxt4Amounttxt = Valuetxt1.getText();
		double ValueTxt4Amount = Double.parseDouble(ValueTxt4Amounttxt);
		String ValueTxt5Amounttxt = Valuetxt1.getText();
		double ValueTxt5Amount = Double.parseDouble(ValueTxt5Amounttxt);

		double sumofAllValues = ValueTxt1Amount + ValueTxt2Amount + ValueTxt3Amount + ValueTxt4Amount + ValueTxt5Amount;

		Assert.assertEquals(TotalBalanceValueAmount, sumofAllValues, "TotalBalanceIsCorrectBasedOnValues");

	}

	public void VerifyingValuesFormattedCorrectly() throws ParseException {

		for (WebElement Value : ValuesTxt) {

			String bigdecimal = Value.getText();
			Locale locale = Locale.US;
			Number number = (BigDecimal) NumberFormat.getCurrencyInstance(locale).parse(bigdecimal);
			System.out.println(number);
			String Amount = NumberFormat.getCurrencyInstance().format(number);
			Assert.assertEquals(Amount, bigdecimal , "Values are formatted correctly");

		}

	}
	
	public void TotalBalanceMatchesSumOftheValues() throws ParseException {
		
		List<Double> numlist = new ArrayList<Double>();

		for (WebElement Value : ValuesTxt) {

			String bigdecimal = Value.getText();
			Locale locale = Locale.US;
			Double number = (Double) NumberFormat.getCurrencyInstance(locale).parse(bigdecimal);
			numlist.add(number);

		}
		
		double sum=0;
		for(double d: numlist) {
			
			sum+=d;
			
		}
		
		Assert.assertEquals(String.valueOf(sum), TotalBalanceValue.getText());
		

	}

}
