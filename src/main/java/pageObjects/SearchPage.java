package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchPage {


    @FindBy(id = "search_form_input_homepage")
    private WebElement inputSearch;
    @FindBy(id = "search_button_homepage")
    private WebElement btnSearchSubmit;
    @FindBy(id = "links_wrapper")
    private WebElement containerSearchResults;
    //@FindBy(xpath = "//div[contains(@class, 'js-images-thumbnails')]")
    @FindBy(xpath = "//div [contains(@class, 'ia-modules js-ia-modules')]")
    private WebElement pictureContainerSearchResults;
    @FindBy(id = "search_form")
    private WebElement searchResultsPageSearchBar;

    //List of search terms
    String[] searchTerms = {
            "Baby Ferret Pictures",
            "Home Gardening",
            "How to hit immortal DOTA2",
            "Stackoverflow helped me again",
            "Bearded Dragon Pictures"
    };

    //Selects random search term to insert into search bar.
    Random randomSearchTerm = new Random();
    int select = randomSearchTerm.nextInt(searchTerms.length);

    //Bot for clicking simulated keys on keyboard.
    Robot robot = new Robot();

    public SearchPage() throws AWTException {
    }


    public void fillSearchInputWithTerm() {
        inputSearch.sendKeys(searchTerms[select]);
    }

    public void clearThenEnterNewSearchTerm(){
        searchResultsPageSearchBar.clear();
        inputSearch.sendKeys(searchTerms[select]);
    }

    public void clickSearchBtn(){
        btnSearchSubmit.click();
    }

    public boolean isSearchResultsDisplayed() {
        if (containerSearchResults.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean isPictureResultsDisplayed(){
        if (pictureContainerSearchResults.isDisplayed()){
            return true;
        }
        return false;
    }

    public void keyboardEnterBtn(){
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}

