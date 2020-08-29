import Utilities.LoggingAssert;
import dao.DOTAData.DOTAData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.DOTABuff.components.MostUsedItemsComponent;

import java.util.List;

import static dao.DOTAData.DOTAData.Hero.*;
import static dao.DOTAData.DOTAData.getMostPopularItemsByHero;


public class DOTABuffTests {
    private final LoggingAssert loggingAssert;
    private final WebDriver driver;

    public DOTABuffTests() {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        loggingAssert = new LoggingAssert();
        driver = new ChromeDriver();
    }

    @DataProvider()
    public Object[][] heroes() {
        return new Object[][]{
                new Object[]{ARC_WARDEN},
                new Object[]{SNAP_FIRE},
                new Object[]{DROW_RANGER},
        };
    }

    @Test(groups = {"Regression", "Search", "Smoke"},
            testName = "Verify most popular items table on hero detail page",
            dataProvider = "heroes")
    public void verifyMostPopularItemsByHero(DOTAData.Hero hero) {
        //var
        List<String> listDBItems;

        //pages
        MostUsedItemsComponent mostUsedItemsComponent = PageFactory.initElements(driver, MostUsedItemsComponent.class);

        //go to hero detail page
        DOTAData.navigateToURLBYHeroName(driver, hero);

        //collect most used items table && set values
        listDBItems = mostUsedItemsComponent.collectMostUsedItemNames();
        for (String item : getMostPopularItemsByHero(hero)) {
            loggingAssert.assertTrue(listDBItems.contains(item),
                    "Verified item: " + item + " is contained in DOTABuff Most Used Items table...");
        }
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
