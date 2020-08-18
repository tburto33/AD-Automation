import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageObjects.DotaBuffWebSite;

public class DotaBuffTests {

    @Test(groups = {"Regression", "Search", "Smoke"},
            testName = "Verify search results from DotaBuff.")

    public void verifyDotaBuffTests() throws InterruptedException {
        //VARS

        // Sets property for location of driver executable.
        // TODO: make this environment var, or build groovy script to automate.
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");

        // Creates new driver instance to use for the duration of this test.
        WebDriver driver = new ChromeDriver();

        //Page Objects
        DotaBuffWebSite dotaBuffPage = new DotaBuffWebSite();

        // Navigates to base URL.
        driver.get("https://www.dotabuff.com/");

        Thread.sleep(5000);
        dotaBuffPage.fillDotaBuffHomeSearchBar("Arc Warden");

        // Calling driver quit to close and dispose of driver and process.
        driver.quit();
    }
}
