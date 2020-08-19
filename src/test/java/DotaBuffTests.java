import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.DotaBuffWebSite;


public class DotaBuffTests {

    // Creates new driver instance to use for the duration of this test.
    WebDriver driver = new ChromeDriver();

    @Test(groups = {"Regression", "Search", "Smoke"},
            testName = "Verify search results from DotaBuff.")

    public void verifyDotaBuffTests() throws InterruptedException {
        //VARS

        // Sets property for location of driver executable.
        // TODO: make this environment var, or build groovy script to automate.
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");

        //Page Objects
        DotaBuffWebSite dBSite = PageFactory.initElements(driver, DotaBuffWebSite.class);

        dBSite.getDBHeroPage(DotaBuffWebSite.DBHeroes.ARC_WARDEN);

        driver.quit();
    }

    // Calling driver quit to close and dispose of driver and process.
//    @AfterTest
//    public void killChromeDriver(){
//        driver.quit();
//    }
}
