package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    WebDriver driver;

    @FindBy(css = "a[href='/products']")
    public WebElement productsButton;

    @FindBy(css = "a[href='/login']")
    public WebElement signupLoginButton;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailInput;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickElementBySelectorone(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
    public void clickSignupLogin() {
        // You can now safely use the initialized element
        signupLoginButton.click();
    }

//    public void enterEmail(String email) {
//        emailInput.sendKeys(email);
//    }
}