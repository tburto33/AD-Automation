import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DotaBuffTests {

    @Test(groups = {"Regression", "Search", "Smoke"},
            testName = "Verify search results from DotaBuff.")

    public void verifyDotaBuffTests(){
        //VARS

        // Sets property for location of driver executable.
        // TODO: make this environment var, or build groovy script to automate.
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");

        // Creates new driver instance to use for the duration of this test.
        WebDriver driver = new ChromeDriver();

        //Page Objects

        // Navigates to base URL.
        driver.get("https://www.dotabuff.com/");


    }
}
