import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.SearchPage;

public class DDGSearchTests {


    @Test(groups = {"Regression", "Search", "Smoke", "Debug"}, testName = "Verify search results from ddg search query.")
    public void verifyDDGSearchResults() {
        // Vars

        // Sets property for location of driver executable.
        // TODO: make this environment var, or build groovy script to automate.
        System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Resources\\chromedriver.exe");

        // Creates new driver instance to use for the duration of this test.
        WebDriver driver = new ChromeDriver();

        //Page Objects
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);

        // Navigates to base URL.
        driver.get("http://duckduckgo.com/");

        //Search with provided term, submit and assert page/picture landing.
        searchPage.fillSearchInputWithTerm();
        searchPage.clickSearchBtn();
        Assert.assertTrue(searchPage.isSearchResultsDisplayed(), "Verifying Search Results Container.");
        Assert.assertTrue(searchPage.isPictureResultsDisplayed(), "Verifying Picture Results Container");


        // Calling driver quit to close and dispose of driver and process.
        driver.quit();



    }

}
