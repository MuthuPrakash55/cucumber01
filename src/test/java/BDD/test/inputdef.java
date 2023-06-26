package BDD.test;

import org.openqa.selenium.By;
import org.testng.Assert;

import factory.driverfactory;
import hooks.myhooks;
import io.cucumber.java.en.*;

public class inputdef extends driverfactory {
	@Given("verify that user navigate to right application")
	public void verifyThatUserNavigateToRightApplication() {
		driver= driverfactory.getdriver();
		  String title=driver.getTitle();
		  Assert.assertEquals(title, "LetCode with Koushik");    
	}
	@When("User click the workspace butoon")
	public void userClickTheWorkspaceButoon() throws Exception {
		driver.findElement(By.xpath(myhooks.getxpath("workspace"))).click();
	    
	}
	@When("user click the edit button")
	public void userClickTheEditButton() {
		String title=driver.getTitle();
	    Assert.assertEquals(title, "LetCode - Testing Hub");
	    
	}
	@Then("verify that user landed in right application page")
	public void verifyThatUserLandedInRightApplicationPage() throws Exception {
		driver.findElement(By.xpath(myhooks.getxpath("edit"))).click();
	    
	}
	@Then("verify that user can able to fill and check the fields")
	public void verifyThatUserCanAbleToFillAndCheckTheFields() throws Exception {
		driver.findElement(By.xpath(myhooks.getxpath("fullname"))).sendKeys(myhooks.getdata("fullname"));
		   driver.findElement(By.xpath(myhooks.getxpath("append"))).sendKeys(myhooks.getdata("append"));;
		   String text=driver.findElement(By.xpath(myhooks.getxpath("insidebox"))).getAttribute("value");
		   System.out.println(text);
		   driver.findElement(By.xpath(myhooks.getxpath("clear"))).clear();
		   boolean enable=driver.findElement(By.xpath(myhooks.getxpath("disabled"))).isEnabled();
		   System.out.println(enable);
		   String readonly=driver.findElement(By.xpath(myhooks.getxpath("readonly"))).getAttribute("readonly");
		   System.out.println(readonly);
		
	    
	}
}
