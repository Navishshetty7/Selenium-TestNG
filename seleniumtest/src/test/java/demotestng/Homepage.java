package demotestng;
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.HomePage;
import org.testng.annotations.*;

public class Homepage extends BaseTest {

    @Test
    public void verifyHomepageTitle() {
        HomePage homePage = new HomePage(driver);
        String expectedTitle = "CurbPOS";
        String actualTitle = driver.getTitle();
        assert actualTitle.equals(expectedTitle);
    }
    @Test(priority = 1)
    public void enterEmailInLoginFieldLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.enterEmail("navish@curbwaste.com");
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='email']")), "Email field does not exist on the page.");
        homePage.clickElementBySelector(By.xpath("//*[@type='submit']"));
        System.out.println("Debugger");

    }



}