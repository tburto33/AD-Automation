package pageObjects;
import DDGData.Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
    @FindBy(id = "search_form_input_homepage")
    public WebElement inputSearchHomepage;
    @FindBy(id = "search_button_homepage")
    private WebElement btnSearchSubmit;
    @FindBy(id = "links_wrapper")
    private WebElement containerSearchResults;
    @FindBy(xpath = "//div [contains(@class, 'ia-modules js-ia-modules')]")
    private WebElement pictureContainerSearchResults;
    @FindBy(id = "search_form_input")
    public WebElement inputSearchResultsPage;
    @FindBy(id = "search_form_input")
    private WebElement inputSearchResultsQuery;

    //Enter any search term and choose which search page to send it to.
    public void fillSearchInputWithTerm(String searchTerm, WebElement inputSearchPage){
        if(inputSearchPage == inputSearchHomepage){
            inputSearchHomepage.clear();
            inputSearchHomepage.sendKeys(searchTerm);
        }else if(inputSearchPage == inputSearchResultsPage){
            inputSearchResultsPage.clear();
            inputSearchResultsPage.sendKeys(searchTerm);
        }
    }

    public void clickSearchBtn(){
        btnSearchSubmit.click();
    }

    public boolean isSearchResultsDisplayed() {
        return containerSearchResults.isDisplayed();
    }

    public boolean isPictureResultsDisplayed(){
        if(!pictureContainerSearchResults.isDisplayed()) {
            System.out.println("Picture container not displayed or not available, returning search results only.");
            return containerSearchResults.isDisplayed();
        }
        return pictureContainerSearchResults.isDisplayed();
        }

    public void keyboardEnterBtn(){
        inputSearchResultsPage.sendKeys(Keys.ENTER);
    }

    public boolean isSearchResultDisplayedInSearchBar(String expectedQuery){
        return getSearchQueryText().equals(expectedQuery);
    }

    public String getSearchQueryText(){
        return inputSearchResultsQuery.getAttribute("Value");
    }

}
