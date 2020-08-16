package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DotaBuffPage {

    //WebPage Elements for DotaBuff
    @FindBy(id = "q")
    private WebElement dotaBuffHomePageSearchBar;

    public void fillDotaBuffHomeSearchBar(String hero) {
        dotaBuffHomePageSearchBar.sendKeys(hero);
    }

}
