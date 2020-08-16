package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DotaBuffPage {

    @FindBy(id = "q")
    private WebElement dotaBuffHomePageSearchBar;

    public void fillDotaBuffHomeSearchBar(String hero) {
        dotaBuffHomePageSearchBar.sendKeys(hero);
    }

}
