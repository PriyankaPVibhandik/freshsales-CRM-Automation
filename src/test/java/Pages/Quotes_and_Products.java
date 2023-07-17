package Freshsales_Automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Quotes_and_Products extends testBase{
	
	login Login_Page;
	home Home_Page;
	
	@FindBy(xpath ="//*[@id='unified360-sidenav-id']/div[4]/ul/li[3]")//.click();
    WebElement DealsManagement;
    
    @FindBy(xpath ="/html/body/div[6]/div[4]/nav/div[4]/ul/li[3]/div[2]/div/div/ul/li[3]/div/div")//.click();
    WebElement Quotes;
    
    @FindBy(xpath ="/html/body/div[6]/div[4]/nav/div[4]/ul/li[3]/div[2]/div/div/ul/li[2]/div/div")//.click()
    WebElement Products;    
    
    @FindBy(xpath ="(//button[@class='ember-view fsa-custom-button fsa-btn-secondary'])[1]")//.click()
    WebElement Assign_to;
    
    @FindBy(xpath ="//span[@class='ember-power-select-placeholder']")//.click()(//span[@class='ember-power-select-status-icon'])[2]
    WebElement quoteClickToSelect;
    
    @FindBy(xpath ="//span[@class='ember-power-select-placeholder']")//.click()
    WebElement productClickToSelect;
    
    @FindBy(xpath ="(//li[@class='ember-power-select-option'])[2]")//.click()
    WebElement Assigned_robbin;
    
    @FindBy(xpath ="//button[@class='ember-view fsa-custom-button fsa-btn-primary']")//.click()
    WebElement save;
    
    @FindBy(xpath ="(//button[@class='ember-view fsa-custom-button fsa-btn-secondary'])[4]")//.click()
    WebElement cancel;
    
    @FindBy(xpath ="(//button[@class='ember-view fsa-custom-button fsa-btn-secondary'])[2]")//.click()
    WebElement Update;
    
    @FindBy(xpath ="//span[@class='ember-power-select-placeholder']")//.click()
    WebElement search_update_field;
    
    @FindBy(xpath ="(//li[@class='ember-power-select-option'])[1]")//.click()
    WebElement update_name_of_field;	
    
    @FindBy(xpath ="//input[@class='ember-view form-control']")//.sendKeys()
    WebElement updated_name;
    
    @FindBy(xpath ="(//button[@class='ember-view fsa-custom-button fsa-btn-secondary'])[3]")//.click() 
    WebElement Delete;
    
    @FindBy(xpath ="//input[@placeholder='Enter value']")//.sendKeys()
    WebElement enter_value_4701;
    
    public Quotes_and_Products() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    
    public void navigateToLoginPage(String url) {
        driver.get(url);
    }
	
	public void assign_quotes_yes() {
		Assign_to.click();
		quoteClickToSelect.click();
		Assigned_robbin.click();
		save.click();
		
	}
	public void assign_quotes_no() {
		Assign_to.click();
		quoteClickToSelect.click();
		Assigned_robbin.click();
		cancel.click();
		}
	public void assign_products_yes() {
		Assign_to.click();
		productClickToSelect.click();
		Assigned_robbin.click();
		save.click();
		}
	public void assign_products_no() {
		Assign_to.click();
		productClickToSelect.click();
		Assigned_robbin.click();
		cancel.click();
	    }
	
	public void update_quotes_yes() {
		Update.click();
		search_update_field.click();
		update_name_of_field.click();
		updated_name.sendKeys("ABC_product");
		save.click();
		}
	
	public void update_quotes_no() {
		Update.click();
		search_update_field.click();
		update_name_of_field.click();
		updated_name.sendKeys("ABC_product");
		cancel.click();
	    }
	
	public void update_products_yes() {
		Update.click();
		search_update_field.click();
		update_name_of_field.click();
		updated_name.sendKeys("ABC_product");
		save.click();
	    }
	public void update_products_no() {
		Update.click();
		search_update_field.click();
		update_name_of_field.click();
		updated_name.sendKeys("ABC_product");
		cancel.click();	
		}
	
	public void delete_quotes_yes() {
		Delete.click();
		enter_value_4701.sendKeys("4701");
		save.click();
	    }

	public void delete_quotes_no() {
		Delete.click();
		enter_value_4701.sendKeys("4701");
		cancel.click();
	    }
	
	public void delete_products_yes() {
		Delete.click();
		enter_value_4701.sendKeys("4701");
		save.click();
	    }
	
	public void delete_products_no() {
		Delete.click();
		enter_value_4701.sendKeys("4701");
		cancel.click();	
		}

	
}
