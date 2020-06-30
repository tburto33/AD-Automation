package pageObjects;

import LoggingAssert.LoggingAssert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class SearchPage {

    @FindBy(id = "search_form_input_homepage")
    private WebElement inputSearchHomepage;
    @FindBy(id = "search_button_homepage")
    private WebElement btnSearchSubmit;
    @FindBy(id = "links_wrapper")
    private WebElement containerSearchResults;
    @FindBy(xpath = "//div [contains(@class, 'ia-modules js-ia-modules')]")
    private WebElement pictureContainerSearchResults;
    @FindBy(id = "search_form_input")
    private WebElement inputSearchResultsPage;
    @FindBy(id = "search_form_input")
    private WebElement inputSearchResultsQuery;

    public void fillSearchInputWithTerm(String searchTerm) {
        inputSearchHomepage.sendKeys(searchTerm);
    }

    public void clearTheSearchBar(){
        inputSearchResultsPage.clear();
    }

    public void fillSearchInputWithTermResultsPage(String searchTerm){
        inputSearchResultsPage.sendKeys(searchTerm);
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
        searchResultsPageSearchBar.sendKeys(Keys.ENTER);
    }

    public boolean isSearchResultDisplayedInSearchBar(String expectedQuery){
        return getSearchQueryText().equals(expectedQuery);
    }

    public String getSearchQueryText(){
//        return inputSearchResultsQuery.getText();
        return inputSearchResultsQuery.getAttribute("Value");
    }

}

