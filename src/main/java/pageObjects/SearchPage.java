package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

    @FindBy(id = "search_form_input_homepage")
    private WebElement inputSearch;
    @FindBy(id = "search_button_homepage")
    private WebElement btnSearchSubmit;
    @FindBy(id = "links_wrapper")
    private WebElement containerSearchResults;
    @FindBy(xpath = "//div[contains(@class, 'js-images-thumbnails')]")
    private WebElement pictureContainerSearchResults;

    public void fillSearchInputWithTerm() {
        inputSearch.sendKeys("Baby Ferret Pictures");
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
}

