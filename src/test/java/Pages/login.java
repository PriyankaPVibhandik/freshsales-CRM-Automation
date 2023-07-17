package Freshsales_Automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class login extends testBase{

	@FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div/div/div/div/div[2]/div[1]/form/div[2]/div[4]/div/button")
    WebElement SigninBtn;
    
    @FindBy(xpath ="//a[@aria-label=\"https://www.freshworks.com/crm/login/\"]")//.click();
    WebElement GoToAccount;
    
    @FindBy(xpath ="/html/body/section/div/div/div[1]/div/form/fieldset/div/div[1]/input")//.sendKeys("svkm-org");
    WebElement ORG;
    
    @FindBy(xpath ="/html/body/section/div/div/div[1]/div/form/input[2]")//.click();
    WebElement SubmitORG;
    
    
    @FindBy(xpath ="//*[@id='unified360-sidenav-id']/div[4]/ul/li[3]")//.click();
    WebElement DealsManagement;
    
    @FindBy(xpath ="/html/body/div[6]/div[4]/nav/div[4]/ul/li[3]/div[2]/div/div/ul/li[3]/div/div")//.click();
    WebElement Quotes;
    
    @FindBy(xpath ="/html/body/div[6]/div[4]/nav/div[4]/ul/li[3]/div[2]/div/div/ul/li[2]/div/div")//.click()
    WebElement Products;    
    
    @FindBy(xpath ="/html/body/div[6]/div[4]/div[4]/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[2]")
    WebElement Existing_Products;
    
    @FindBy(xpath ="/html/body/div[6]/div[4]/div[3]/div[3]/div/div[2]/button/span")//.click()
    WebElement Add_Products;
    
    @FindBy(xpath ="//input[@name='product[name]']")//.sendKeys()
    WebElement Product_name;
    
    @FindBy(xpath ="/html/body/div[6]/div[5]/div[2]/div/div/div[2]/div/div/div/div/form/div[1]/div/div[2]/div/div[1]/span[1]")//.clcick()
    WebElement choose_value;
    
    @FindBy(xpath ="/html/body/div[6]/div[5]/div[2]/div/div/div[2]/div/div/div/div/form/div[1]/div/div[2]/div/div[2]/div/ul/li[2]")//.click()
    WebElement hardware;
    
    @FindBy(xpath ="//input[@name='product[skuNumber]']")//.sendKeys()
    WebElement SKU_number;
    
    @FindBy(xpath ="//input[@placeholder='Choose date']")//.sendKeys(mm/dd/yy)
    WebElement choose_date;
    
    @FindBy(xpath =" //button[@type='submit']")
    WebElement save_product;
    
    @FindBy(xpath ="//button[@class='close']")//.clcick()
    WebElement close_page;
	
    @FindBy(xpath ="//a[@title='New Product']")
    WebElement view_added_product;
    
    
    //single and multi select products
    
    @FindBy(xpath ="//input[@name='checkbox_402000041044']")//.click()
    WebElement first_product;
    
    @FindBy(xpath ="//input[@name='checkbox_402000040704']")//.click()
    WebElement second_product;
    
    @FindBy(xpath ="//input[@name='checkbox_402000041046']")//.click()
    WebElement third_product;
    
    @FindBy(xpath ="(//button[@class='ember-view fsa-custom-button fsa-btn-secondary'])[1]")//.click()
    WebElement Assign_to;
    
    @FindBy(xpath ="(//button[@class='ember-view fsa-custom-button fsa-btn-secondary'])[2]")//.click()
    WebElement Update;
    
    @FindBy(xpath ="(//button[@class='ember-view fsa-custom-button fsa-btn-secondary'])[3]")//.click() 
    WebElement Delete;
    
    @FindBy(xpath ="(//span[@class='cursor-pointer'])[1]")//.click()
    WebElement Name;
    
    @FindBy(xpath ="(//span[@class='cursor-pointer'])[2]")//.click()
    WebElement Active;

    @FindBy(xpath ="(//span[@class='cursor-pointer'])[4]")//.click()
    WebElement Category;    

    @FindBy(xpath ="(//span[@class='cursor-pointer'])[5]")//.click()
    WebElement Created_At;  
    
    public login() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    
    public void navigateToLoginPage(String url) {
        driver.get(url);
    }
        
    public home login_page(String org, String user, String pwd) {
    	GoToAccount.click();
    	ORG.sendKeys(org);
    	SubmitORG.click();
    	
    	Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        
     // Wait until the login page header is displayed
    	wait.until(driver -> driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/div/div/div[1]/div/h1")).isDisplayed());
        
        username.sendKeys(user);
        password.sendKeys(pwd);
        SigninBtn.click();

      //after login 
        Wait<WebDriver> wait2 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        // Wait until the element after login is displayed
        wait2.until(driver -> driver.findElement(By.xpath(" /html/body/div[6]/div[4]/div[4]/div/div[1]/div/p/span")).isDisplayed());
        return new home();
             }  
    
    public void productsPage() {
    	DealsManagement.click();
    	Products.click();
    	
    }
    
    public void quotesPage() {
    	DealsManagement.click();
    	Quotes.click();
    	
    }
    
    public void addProducts() {
    	Add_Products.click();
    	Product_name.sendKeys("New Product");
    	choose_value.click();
    	hardware.click();
    	SKU_number.sendKeys("1234");
    	save_product.click();
    	close_page.click();
        
    }
    
    public void single_select_product() {
    	first_product.click();
    	
    }
    
    public void multi_select_product() {
    	second_product.click();
    	third_product.click();
    	
    }
    
    public void sortable_columns_Name() {
    	Name.click();
    	
    }
    
	public void sortable_columns_Active() {
		Active.click();
	 
	    }
	
	public void sortable_columns_Category() {
		Category.click();
	 
	    }
	public void sortable_columns_Created_At() {
		Created_At.click();
    
    }
 
}



