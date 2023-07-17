package Freshsales_Automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class home extends testBase{
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
    
    public home() {
        PageFactory.initElements(driver, this);
    }
}
