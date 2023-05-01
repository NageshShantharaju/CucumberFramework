package stepDefinitions;


import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	
	public static WebDriver driver;
	public Actions actions;

	 @Given("^User is clicking the valid URL$")
	    public void user_is_clicking_the_valid_url() throws Throwable {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://whatfix.com/");
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	    }

	    @Given("^User is clicking the Customers link$")
	    public void user_is_clicking_the_customers_link() throws Throwable {
	    	Thread.sleep(3000);
	       driver.findElement(By.xpath("//a[text()='Customers']")).click();
	      
	    }

	    @Given("^User is clicking the Pricing link$")
	    public void user_is_clicking_the_pricing_link() throws Throwable {
	    	Thread.sleep(3000);
	    	 driver.findElement(By.xpath("//a[text()='Pricing']")).click();
	    }

	    @Given("^User is clicking the Resources link$")
	    public void user_is_clicking_the_resources_link() throws Throwable {
	    	Thread.sleep(5000);
	    	 actions = new Actions(driver);
	    	 WebElement target = driver.findElement(By.xpath("//a[text()='Resources']"));
	    	 actions.moveToElement(target).build().perform();
	    	 driver.findElement(By.xpath("(//a[@class='link-content' and @href='/resources/'])[2]")).click();
	    	 
	    }

	    @When("^Portal navigates to the Homepage$")
	    public void portal_navigates_to_the_homepage() throws Throwable {
	    	Thread.sleep(3000);
	       boolean logo = driver.findElement(By.xpath("//a[@class='site-logo']")).isDisplayed();
	       if(logo == true)
	       {
	    	   Assert.assertTrue(true);
	       }
	       else
	       {
	    	   Assert.assertTrue(false);
	       }
	    }

	    @When("^Customers page is opened$")
	    public void customers_page_is_opened() throws Throwable {
	    	Thread.sleep(3000);
	    	String customerPageUrl= driver.getCurrentUrl();
	       Assert.assertEquals(customerPageUrl, "https://whatfix.com/customers/");
	    }

	    @When("^Pricing page is opened$")
	    public void pricing_page_is_opened() throws Throwable {
	    	Thread.sleep(3000);
	    	String pricingPageUrl= driver.getCurrentUrl();
		       Assert.assertEquals(pricingPageUrl, "https://whatfix.com/pricing/");
	    }

	    @When("^Resources page is opened$")
	    public void resources_page_is_opened() throws Throwable {
	    	Thread.sleep(3000);
	    	String resourcePageUrl= driver.getCurrentUrl();
		       Assert.assertEquals(resourcePageUrl, "https://whatfix.com/resources/");
	    }

	    @Then("^User validate the site is opened or not$")
	    public void user_validate_the_site_is_opened_or_not() throws Throwable {
	    	Thread.sleep(3000);
	        String titlePage = driver.getTitle();
	        Assert.assertEquals(titlePage, "Whatfix | Drive Digital Adoption");
	    }

	    @Then("^User validate the Customers page is opened or not$")
	    public void user_validate_the_customers_page_is_opened_or_not() throws Throwable {
	    	Thread.sleep(3000);
	    	String customerPageUrl= driver.getCurrentUrl();
		       Assert.assertEquals(customerPageUrl, "https://whatfix.com/customers/");
	    }

	    @Then("^User validate the Pricing page is opened or not$")
	    public void user_validate_the_pricing_page_is_opened_or_not() throws Throwable {
	    	Thread.sleep(3000);
	    	String pricingPageUrl= driver.getCurrentUrl();
		       Assert.assertEquals(pricingPageUrl, "https://whatfix.com/pricing/");
	    }


	    @Then("^User validate the Resources page is opened or not$")
	    public void user_validate_the_resources_page_is_opened_or_not() throws Throwable {
	    	Thread.sleep(7000);
	    	String resourcePageUrl= driver.getCurrentUrl();
		    Assert.assertEquals(resourcePageUrl, "https://whatfix.com/resources/");
		       driver.close();
	    }
	    
	    @Given("^User is clicking the mobile URL$")
	    public void user_is_clicking_the_mobile_url() throws Throwable {
	    	Thread.sleep(3000);
	    	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	       driver.get("https://www.91mobiles.com/");
	       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	    }

	    @When("^user is in mobile landing$")
	    public void user_is_in_mobile_landing() throws Throwable {
	    	Thread.sleep(3000);
	       String mobileUrl = driver.getCurrentUrl();
	       Assert.assertEquals(mobileUrl, "https://www.91mobiles.com/");
	    }

	    @Then("^search for the Apple mobiles in the search box$")
	    public void search_for_the_apple_mobiles_in_the_search_box() throws Throwable {
	    	Thread.sleep(3000);
	    	WebElement searchBox = driver.findElement(By.xpath("(//input[@type='text' and @ng-click='onFirstClick()'])[1]"));
	    	searchBox.click();
	    	searchBox.sendKeys("Apple Mobiles");
	    }

	    @And("^Count the number of search is displaying in the page$")
	    public void count_the_number_of_search_is_displaying_in_the_page() throws Throwable {
	    	Thread.sleep(3000);
	    	List<WebElement> noOfItems = driver.findElements(By.xpath("//li[@ng-repeat='items in phones']"));
	    	System.out.println("********Number of Search Results********* " + noOfItems.size());
	    }

	    @And("^Print the mobile names and its price in console$")
	    public void print_the_mobile_names_and_its_price_in_console() throws Throwable {
	    	Thread.sleep(3000);
	    	List<WebElement> noOfItems  = driver.findElements(By.xpath("//li[@ng-repeat='items in phones']"));
	    	for (int i=0; i<noOfItems.size();i++)
	    	{
	    	      System.out.println("Printing the search Results:" + noOfItems.get(i).getText().split("-")[0]);
	    	}
	    	
    }

	    @And("^Close the browser$")
	    public void close_the_browser() throws Throwable {
	    	Thread.sleep(3000);
	    	driver.close();
	    }



}
