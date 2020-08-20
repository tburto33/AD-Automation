package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class DotaBuffWebSite {

    private final String dotaBuffURL = "https://www.dotabuff.com";

    WebDriver driver = new ChromeDriver();

    @FindBy(xpath = "//div [contains(@h1, 'Arc Warden')]")
    private WebElement arcWardenPageHeader;
    @FindBy(xpath = "//div [contains(@h1, 'Drow Ranger')]")
    private WebElement drowRangerPageHeader;
    @FindBy(xpath = "//div [contains(@h1, 'Snapfire')]")
    private WebElement snapfirePageHeader;

    public boolean isHeroDisplayed(){
        return arcWardenPageHeader.isDisplayed();
    }


    public void getDBHeroPage(DBHeroes heroName){
        switch(heroName){
            case ARC_WARDEN:
                driver.get(dotaBuffURL + DBHeroURL.ARC_WARDEN_URL);
                break;
            case DROW_RANGER:
                driver.get(dotaBuffURL + DBHeroURL.DROW_RANGER_URL);
                break;
            case SNAPFIRE:
                driver.get(dotaBuffURL + DBHeroURL.SNAPFIRE_URL);
        }
    }

    public enum DBHeroes{
        ARC_WARDEN,
        DROW_RANGER,
        SNAPFIRE;
    }

    public enum DBHeroURL {

        ARC_WARDEN_URL{
            @Override
            public String toString(){
                return "/heroes/arc-warden";
            }
        },
        DROW_RANGER_URL{
            @Override
            public String toString(){
                return "/heroes/drow-ranger";
            }
        },
        SNAPFIRE_URL{
            @Override
            public String toString(){
                return "/heroes/snapfire";
            }
        }
    }
}
