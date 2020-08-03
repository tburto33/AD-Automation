import DDGData.DDGData;
import LoggingAssert.LoggingAssert;
import RandomHelpers.RandomHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SearchPage;
import java.util.List;
import static pageObjects.SearchPage.SearchPageContext.INPUT_SEARCH_HOME_PAGE;
import static pageObjects.SearchPage.SearchPageContext.INPUT_SEARCH_RESULTS_PAGE;

public class DDGSearchTests {
    @Test(groups = {"Regression", "Search", "Smoke"},
            testName = "Verify search results from ddg search query.")
    public void verifyDDGSearchResults() {
        // Vars
        List<String> availSearchTerms = DDGData.getSearchTerms();
        String randomTerm1 = RandomHelpers.getRandomStringFromList(availSearchTerms);
        availSearchTerms.remove(randomTerm1);
        String randomTerm2 = RandomHelpers.getRandomStringFromList(availSearchTerms);
        availSearchTerms.remove(randomTerm2);

        // Sets property for location of driver executable.
        // TODO: make this environment var, or build groovy script to automate.
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");

        // Creates new driver instance to use for the duration of this test.
        WebDriver driver = new ChromeDriver();

        //Page Objects
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        LoggingAssert.TrueAssert trueAssert = new LoggingAssert.TrueAssert();

        // Navigates to base URL.
        driver.get("http://duckduckgo.com/");

        //Search with provided term, submit and assert page/picture landing, search query in search results.
        searchPage.fillSearchTermToSelectedPage(randomTerm1, INPUT_SEARCH_HOME_PAGE);
        searchPage.clickSearchBtn();
        trueAssert.executeAssert(searchPage.isSearchResultsDisplayed(), "Search Results Displayed");
        trueAssert.executeAssert(searchPage.isPictureResultsDisplayed(), "Picture Results Displayed");
        Assert.assertEquals(searchPage.getSearchQueryText(), randomTerm1, "Verifying Search Query Input");

        //Next test, same as above with using keyboard enter key.
        searchPage.fillSearchTermToSelectedPage(randomTerm2, INPUT_SEARCH_RESULTS_PAGE);
        searchPage.keyboardEnterBtn();
        trueAssert.executeAssert(searchPage.isSearchResultsDisplayed(),"Search Results Displayed");
        trueAssert.executeAssert(searchPage.isPictureResultsDisplayed(),"Picture Results Displayed");
        Assert.assertEquals(searchPage.getSearchQueryText(), randomTerm2, "Verifying Search Query Input");

        // Calling driver quit to close and dispose of driver and process.
        driver.quit();
    }
}
