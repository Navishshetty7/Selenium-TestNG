package pages;
import utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    WebDriver driver;

    @FindBy(css = "a[href='/products']")
    WebElement productsButton;

    @FindBy(css = "a[href='/login']")
    WebElement signupLoginButton;

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailInput;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }
}