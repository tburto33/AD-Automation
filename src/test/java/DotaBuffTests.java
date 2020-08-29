import Utilities.LoggingAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.DotaBuffWebSite;


public class DotaBuffTests {

    LoggingAssert loggingAssert = new LoggingAssert();

    @Test(groups = {"Regression", "Search", "Smoke"},
            testName = "Verify search results from DotaBuff.")

    public void verifyDotaBuffTests() {
        //VARS

        // Sets property for location of driver executable.
        // TODO: make this environment var, or build groovy script to automate.
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");

        //Creates new driver instance for use of testing.
        WebDriver driver = new ChromeDriver();

        //Page Objects
        DotaBuffWebSite dBSite = PageFactory.initElements(driver, DotaBuffWebSite.class);

        driver.get("https://www.dotabuff.com/heroes/arc-warden");
        loggingAssert.assertTrue(dBSite.arcWardenIsDisplayed());
        dBSite.arcWardenTopItems();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

        driver.get("https://www.dotabuff.com/heroes/drow-ranger");
        loggingAssert.assertTrue(dBSite.drowRangerIsDisplayed());
        dBSite.drowRangerTopItems();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

        driver.get("https://www.dotabuff.com/heroes/snapfire");
        loggingAssert.assertTrue(dBSite.snapFireIsDisplayed());
        dBSite.snapFireTopItems();

        driver.quit();
    }

    // Calling driver quit to close and dispose of driver and process.
//    @AfterTest
//    public void killChromeDriver(){
//        driver.quit();
//    }
}
