package demotestng;
//import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.HomePage;
import org.testng.annotations.*;

import java.time.Duration;

public class Homepage {
    protected WebDriver driver;
    @BeforeMethod
    public void setup() {
        // Set up the ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set an implicit wait to handle element loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the application URL
        driver.get("https://automationexercise.com/");
    }

    @AfterMethod
    public void teardown() {
        // Close the browser if the driver is not null
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyHomepageTitle() {
        HomePage homePage = new HomePage(driver);
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        assert actualTitle.equals(expectedTitle);
    }
//    @Test(priority = 1)
//    public void Home(){
//
//    }


//    @Test(priority = 1)
//    public void enterEmailInLoginFieldLogin() {
//        HomePage homePage = new HomePage(driver);
//        homePage.enterEmail("navish@curbwaste.com");
//        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='email']")), "Email field does not exist on the page.");
//        homePage.clickElementBySelector(By.xpath("//*[@type='submit']"));
//        System.out.println("Debugger");
//
//    }



}