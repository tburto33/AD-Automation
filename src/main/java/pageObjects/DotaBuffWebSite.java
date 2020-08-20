package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;

public class DotaBuffWebSite {

    //Arc Warden WebElements
    @FindBy(xpath = "//img [contains(@alt, 'Arc Warden')]")
    private WebElement arcWardenPageHeaderHeroImage;
    @FindBy(xpath = "//a [contains(@href, '/heroes/arc-warden/items')]")
    private WebElement arcWardenMoreItemsButton;
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[2]/div[3]/div[1]/div[1]/section[4]/article/table/tbody/tr[1]/td[1]/div/a/img")
    private WebElement arcWardenFirstItem;
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[2]/div[3]/div[1]/div[1]/section[4]/article/table/tbody/tr[2]/td[1]/div/a/img")
    private WebElement arcWardenSecondItem;
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[2]/div[3]/div[1]/div[1]/section[4]/article/table/tbody/tr[3]/td[1]/div/a/img")
    private WebElement arcWardenThirdItem;

    //Drow Ranger WebElements
    @FindBy(xpath = "//img [contains(@alt, 'Drow Ranger')]")
    private WebElement drowRangerPageHeaderHeroImage;

    //SnapFire WebElements
    @FindBy(xpath = "//img [contains(@alt, 'Snapfire')]")
    private WebElement snapfirePageHeaderHeroImage;

    public boolean arcWardenTest(){
        return arcWardenPageHeaderHeroImage.isDisplayed();
    }

    public void arcWardenFirstItem(){
        System.out.println(arcWardenFirstItem.getAttribute("oldtitle"));
        System.out.println(arcWardenSecondItem.getAttribute("oldtitle"));
        System.out.println(arcWardenThirdItem.getAttribute("oldtitle"));
    }

}
