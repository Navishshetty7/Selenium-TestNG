package demotestng;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import org.testng.annotations.DataProvider;
import pages.LoginPage;

import java.time.Duration;

public class Loginpagetest extends BaseTest{
    //protected WebDriver driver;

    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        // Each row is a set of test data: { Name, Email }
        return new Object[][]{
                {"TestUserOne", "user.one@example.com"},
                {"TestUserTwo", "user.two@example.com"},
                {"TestUserThree", "user.three@example.com"}
        };
    }

    @Test(dataProvider = "registrationData")
    public void newUserSignValidone(String Name, String Email){
        System.out.println(Email+" "+Name);
        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();
        LoginPage loginPage = new LoginPage(driver);
        String expHeadText= "New User Signup!";
        WebElement Headtext= driver.findElement(By.xpath("//div[@class='signup-form']/h2[text()='New User Signup!']"));
        String head_text = Headtext.getText();
        Assert.assertEquals(head_text, expHeadText, "Verification Header text did not match.");
        loginPage.enterName(Name);
        loginPage.enterEmail(Email);
        loginPage.clickSignUp();
    }

}
