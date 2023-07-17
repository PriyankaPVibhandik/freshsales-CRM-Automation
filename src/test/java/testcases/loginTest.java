package Freshsales_Automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;



public class loginTest extends testBase{
	
	login Login_Page;
	home Home_Page;
	
	public loginTest() {
        super();
    }
	
	@BeforeMethod
    public void setup() {
        initialize();
        Login_Page = new login();
    }
	
	@Test(priority = 1 , description = "Verify that on providing valid credentials user is able to login")
	public void Successful_login() {
    	Login_Page.navigateToLoginPage(prop.getProperty("url"));
    	Home_Page = Login_Page.login_page(prop.getProperty("org"), prop.getProperty("username"), prop.getProperty("password"));
        
    	
    	//after login 
        Wait<WebDriver> wait2 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        wait2.until(driver -> driver.findElement(By.xpath(" /html/body/div[6]/div[4]/div[4]/div/div[1]/div/p/span")).isDisplayed()); 
      
        
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));

        wait.until(ExpectedConditions.titleIs("Contacts : Freshsales")); // Wait until the page title is "Contacts : Freshsales"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Contacts : Freshsales";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title assertion failed!");


    }
	
	@Test(priority = 2 , description = "Verify that the products page and existing products are visible")
	public void Existing_Products() {
		Login_Page.navigateToLoginPage(prop.getProperty("url"));
    	Home_Page = Login_Page.login_page(prop.getProperty("org"), prop.getProperty("username"), prop.getProperty("password"));
        
    	
    	//after login 
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        wait.until(driver -> driver.findElement(By.xpath(" /html/body/div[6]/div[4]/div[4]/div/div[1]/div/p/span")).isDisplayed()); 
        
		Login_Page.productsPage();
		Wait<WebDriver> wait2 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        
     // Wait until the existing products are displayed
    	wait2.until(driver -> driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[4]/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[2]")).isDisplayed());
        
    	// Assert that the element exists
        boolean isElementExists = driver.findElements(By.xpath("/html/body/div[6]/div[4]/div[4]/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[2]")).size() > 0;
        Assert.assertTrue(isElementExists, "The element does not exist!");

	}
	
	@Test(priority = 3 , description = "Add and view newely added products ")
	public void Add_Products() {
		Login_Page.navigateToLoginPage(prop.getProperty("url"));
    	Home_Page = Login_Page.login_page(prop.getProperty("org"), prop.getProperty("username"), prop.getProperty("password"));
        
    	
    	//after login 
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        wait.until(driver -> driver.findElement(By.xpath(" /html/body/div[6]/div[4]/div[4]/div/div[1]/div/p/span")).isDisplayed()); 
        
		Login_Page.productsPage();
		Wait<WebDriver> wait2 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        
     // Wait until the existing products are displayed
    	wait2.until(driver -> driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[4]/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[2]")).isDisplayed());
    	
    	//products page gets opened
    	
    	Login_Page.addProducts();
    	
    	// Refresh the web page
        driver.navigate().refresh();
    	 // Assert that the element exists
        boolean isElementExists = driver.findElements(By.xpath("//a[@title='New Product']")).size() > 0;
        Assert.assertTrue(isElementExists, "The element does not exist!");

	}
	
	@Test(priority = 4 , description = "verify that products can be selected in single and multi-select fashion ")
	public void single_multi_select_products() {
		Login_Page.navigateToLoginPage(prop.getProperty("url"));
    	Home_Page = Login_Page.login_page(prop.getProperty("org"), prop.getProperty("username"), prop.getProperty("password"));
        
    	
    	//after login 
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        wait.until(driver -> driver.findElement(By.xpath(" /html/body/div[6]/div[4]/div[4]/div/div[1]/div/p/span")).isDisplayed()); 
        
		Login_Page.productsPage();
		Wait<WebDriver> wait2 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        
     // Wait until the existing products are displayed
    	wait2.until(driver -> driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[4]/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[2]")).isDisplayed());
    	
    	//products page gets opened
    	
//    	// Click on the element with the specified XPath
//        driver.findElement(By.xpath("//input[@name='checkbox_402000041044']")).click();
        
    	// Wait for 5 seconds for the user to manually click on the check boxes
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       	
//    	Login_Page.single_select_product();
//    	//Login_Page.multi_select_product();
//    	
    	// on selection the assignTo, update and delete options appear
    	
    	Wait<WebDriver> wait3 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        
     // Wait until the assignTo, update and delete options appear
    	wait3.until(driver -> driver.findElement(By.xpath("(//button[@class='ember-view fsa-custom-button fsa-btn-secondary'])[1]")).isDisplayed());
   	 // Assert that the element exists
      boolean isElementExists = driver.findElements(By.xpath("(//button[@class='ember-view fsa-custom-button fsa-btn-secondary'])[1]")).size() > 0;
      Assert.assertTrue(isElementExists, "Products cannot be multi selected");
	}
	
	@Test(priority = 5 , description = "verify that cloumns like name, active, catrgory, created-at are sortable ")
	public void sortable_columns() {
		Login_Page.navigateToLoginPage(prop.getProperty("url"));
    	Home_Page = Login_Page.login_page(prop.getProperty("org"), prop.getProperty("username"), prop.getProperty("password"));
        
    	//after login 
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        wait.until(driver -> driver.findElement(By.xpath(" /html/body/div[6]/div[4]/div[4]/div/div[1]/div/p/span")).isDisplayed()); 
        
		Login_Page.productsPage();
		Wait<WebDriver> wait2 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
		//products page gets opened
		
     // Wait until the existing products are displayed
    	wait2.until(driver -> driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[4]/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[2]")).isDisplayed());
    	
    	
	
    	Login_Page.sortable_columns_Name();
    	Login_Page.sortable_columns_Active();
    	Login_Page.sortable_columns_Category();
    	Login_Page.sortable_columns_Created_At();
    	
    	// Assert that the element exists
        boolean isElementExists = driver.findElements(By.xpath("//a[@title='All Products']")).size() > 0;
        Assert.assertTrue(isElementExists, "columns are not sortable");
  	
	}
	
	@AfterMethod
    public void tearDown() {
        driver.quit();
    }
}



