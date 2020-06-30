import com.google.common.base.Verify;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.SearchPage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DDGSearchTests {

    SoftAssert softAssert = new SoftAssert();

    @Test(groups = {"Regression", "Search", "Smoke"}, testName = "Verify search results from ddg search query.")
    public void verifyDDGSearchResults() throws InterruptedException {
        // Vars
//        List<String> searchTerms = new ArrayList<>();
//        searchTerms.add("Baby Ferret Pictures");
//        searchTerms.add("Home Gardening");
//        searchTerms.add("How to hit immortal DOTA2");
//        searchTerms.add("Stackoverflow helped me again");
//        searchTerms.add("Bearded Dragon Pictures");
//
//        Random random = new Random();
//        int randomIndex = random.nextInt(searchTerms.size() -1);
//        String randomTerm1 = searchTerms.get(randomIndex);
//        String randomTerm2 = searchTerms.get(randomIndex);

        // Sets property for location of driver executable.
        // TODO: make this environment var, or build groovy script to automate.
        System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
        // Creates new driver instance to use for the duration of this test.
        WebDriver driver = new ChromeDriver();
        //Page Objects
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        DDGData ddgData = new DDGData();
        // Navigates to base URL.
        driver.get("http://duckduckgo.com/");
        //Search with provided term, submit and assert page/picture landing, search query in search results,.
        searchPage.fillSearchInputWithTerm(randomTerm1);
        searchPage.fillSearchInputWithTerm();
        searchPage.clickSearchBtn();
        Assert.assertTrue(searchPage.isSearchResultsDisplayed(), "Verifying Search Results Container.");
        softAssert.assertTrue(searchPage.isPictureResultsDisplayed(), "Verifying Picture Results Container");
        Assert.assertEquals(searchPage.getSearchQueryText(), randomTerm1, "Verifying Search Query Input");
        //Next test, same as above with using keyboard enter key.
        searchPage.clearTheSearchBar();
        searchPage.fillSearchInputWithTermResultsPage(randomTerm2);
        searchPage.keyboardEnterBtn();
        Assert.assertTrue(searchPage.isSearchResultsDisplayed(), "Verifying Search Results Container.");
        softAssert.assertTrue(searchPage.isPictureResultsDisplayed(), "Verifying Picture Results Container");
        Assert.assertEquals(searchPage.getSearchQueryText(), randomTerm2, "Verifying Search Query Input");
        // Calling driver quit to close and dispose of driver and process.
        driver.quit();
    }
}
