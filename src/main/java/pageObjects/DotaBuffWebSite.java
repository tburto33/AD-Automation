package pageObjects;

import DotaData.DotaData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLOutput;
import java.util.HashMap;

public class DotaBuffWebSite {

    DotaData dotaData;

    //Arc Warden WebElements
    @FindBy(xpath = "//img [contains(@alt, 'Arc Warden')]")
    private WebElement arcWardenPageHeaderHeroImage;
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[2]/div[3]/div[1]/div[1]/section[4]/article/table/tbody/tr[1]/td[1]/div/a/img")
    private WebElement arcWardenFirstItem;
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[2]/div[3]/div[1]/div[1]/section[4]/article/table/tbody/tr[2]/td[1]/div/a/img")
    private WebElement arcWardenSecondItem;
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[2]/div[3]/div[1]/div[1]/section[4]/article/table/tbody/tr[3]/td[1]/div/a/img")
    private WebElement arcWardenThirdItem;

    //Drow Ranger WebElements
    @FindBy(xpath = "//img [contains(@alt, 'Drow Ranger')]")
    private WebElement drowRangerPageHeaderHeroImage;
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[2]/div[3]/div[1]/div[1]/section[5]/article/table/tbody/tr[1]/td[1]/div/a/img")
    private WebElement drowRangerFirstItem;
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[2]/div[3]/div[1]/div[1]/section[5]/article/table/tbody/tr[2]/td[1]/div/a/img")
    private WebElement drowRangerSecondItem;
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[2]/div[3]/div[1]/div[1]/section[5]/article/table/tbody/tr[3]/td[1]/div/a/img")
    private WebElement drowRangerThirdItem;

    //SnapFire WebElements
    @FindBy(xpath = "//img [contains(@alt, 'Snapfire')]")
    private WebElement snapfirePageHeaderHeroImage;
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[2]/div[3]/div[1]/div[1]/section[5]/article/table/tbody/tr[1]/td[1]/div/a/img")
    private WebElement snapFireFirstItem;
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[2]/div[3]/div[1]/div[1]/section[5]/article/table/tbody/tr[2]/td[1]/div/a/img")
    private WebElement snapFireSecondItem;
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[2]/div[3]/div[1]/div[1]/section[5]/article/table/tbody/tr[3]/td[1]/div/a/img")
    private WebElement snapFireThirdItem;

    public boolean arcWardenIsDisplayed(){
        return arcWardenPageHeaderHeroImage.isDisplayed();
    }

    public boolean drowRangerIsDisplayed(){
        return drowRangerPageHeaderHeroImage.isDisplayed();
    }

    public boolean snapFireIsDisplayed(){
        return snapfirePageHeaderHeroImage.isDisplayed();
    }

    public void arcWardenTopItems(){
        String firstItemName = arcWardenFirstItem.getAttribute("oldtitle");
        String secondItemName = arcWardenSecondItem.getAttribute("oldtitle");
        String thirdItemName = arcWardenThirdItem.getAttribute("oldtitle");

        HashMap<Integer, String> arcWarden = dotaData.getArcWarden();
        arcWarden.put(1, firstItemName);
        arcWarden.put(2, secondItemName);
        arcWarden.put(3, thirdItemName);
        System.out.println("Arc Warden's Top Items This Week: " + "\n" + arcWarden);
    }

    public void drowRangerTopItems(){
        String firstItemName = drowRangerFirstItem.getAttribute("oldtitle");
        String secondItemName = drowRangerSecondItem.getAttribute("oldtitle");
        String thirdItemName = drowRangerThirdItem.getAttribute("oldtitle");

        HashMap<Integer, String> drowRanger = dotaData.getDrowRanger();
        drowRanger.put(1, firstItemName);
        drowRanger.put(2, secondItemName);
        drowRanger.put(3, thirdItemName);
        System.out.println("Drow Ranger's Top Items This Week: " + "\n" + drowRanger);
    }

    public void snapFireTopItems(){
        String firstItemName = snapFireFirstItem.getAttribute("oldtitle");
        String secondItemName = snapFireSecondItem.getAttribute("oldtitle");
        String thirdItemName = snapFireThirdItem.getAttribute("oldtitle");

        HashMap<Integer, String> snapFire = dotaData.getSnapFire();
        snapFire.put(1, firstItemName);
        snapFire.put(2, secondItemName);
        snapFire.put(3, thirdItemName);
        System.out.println("SnapFire's Top Items This Week: " + "\n" + snapFire);
    }
}
