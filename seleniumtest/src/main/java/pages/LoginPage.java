package pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePage;

import java.sql.Time;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    WebDriver driver;

    @FindBy(xpath = "//input[@type='text' and @data-qa='signup-name']")
    public WebElement SignupName;

    @FindBy(xpath = "//input[@type='email' and @data-qa='signup-email']")
    public WebElement SignupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement SignupBtn;

    @FindBy(xpath = "//h2[@class='title text-center']/b[text()='Enter Account Information']")
    public WebElement AccountInfoTitle;

    public void enterName(String Name){
        logger.info("Entering name '{}' into field", Name);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(SignupName));
            SignupName.sendKeys(Name);
        } catch (TimeoutException e){
            logger.error("Timeout: SignUpName was not visible. Locator: {}", SignupName, e);
            throw new TimeoutException("Failed to click SignUpName button due to timeout. Locator: " + SignupName, e);
        }
    }
    public void enterEmail(String Email) {
        logger.info("Entering Email '{}' into field", Email);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(SignupEmail));
            SignupEmail.sendKeys(Email);
        } catch (TimeoutException e)
            {
                logger.error("Timeout: SignUpEmail button was not clickable. Locator: {}", SignupEmail, e);
                throw new TimeoutException("Failed to click SignUpEmail button due to timeout. Locator: " + SignupEmail, e);
        }
    }

    public void clickSignUp(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(SignupBtn));
            SignupBtn.click();
            logger.info("Successfully clicked the SignUp button.");
        } catch (TimeoutException e) {
            logger.error("Timeout: SignUp button was not clickable. Locator: {}", SignupBtn, e);
            throw new TimeoutException("Failed to click SignUp button due to timeout. Locator: " + SignupBtn, e);
        }

    }
    public void enterRegisterDetails(){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(AccountInfoTitle));
        } catch (TimeoutException e) {
            logger.error("Timeout: SignUp button was not visible. Locator: {}", AccountInfoTitle, e);
            throw new TimeoutException("Failed to click SignUp button due to timeout. Locator: " + AccountInfoTitle, e);
        }

        //input[@type='radio' and @value ='Mrs']
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
