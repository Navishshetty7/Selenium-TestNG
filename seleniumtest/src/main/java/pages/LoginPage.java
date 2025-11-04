package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BasePage;

public class LoginPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@type='text' and @data-qa='signup-name']")
    public WebElement SignupName;

    @FindBy(xpath = "//input[@type='email' and @data-qa='signup-email']")
    public WebElement SignupEmail;

    public void enterName(String Name){
        wait.until(ExpectedConditions.elementToBeClickable(SignupName));
        SignupName.sendKeys(Name);
    }
    public void enterEmail(String Email){
        wait.until(ExpectedConditions.elementToBeClickable(SignupEmail));
        SignupEmail.sendKeys(Email);
    }
    

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
