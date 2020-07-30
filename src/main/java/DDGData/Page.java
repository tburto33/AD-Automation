package DDGData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public enum Page {

    INPUTSEARCHHOMEPAGE,
    INPUTSEARCHRESULTSPAGE;
}

    @FindBy(id = "search_form_input_homepage")
    private WebElement inputSearchHomepage;
    @FindBy(id = "search_form_input")
    private WebElement inputSearchResultsPage;

    public void selectWhichPageToEnterSearchTerm(Page whichInputPage, String searchTerm ){
        switch(whichInputPage){
            case INPUTSEARCHHOMEPAGE:
                inputSearchHomepage.sendKeys(searchTerm);
                break;
            case INPUTSEARCHRESULTSPAGE:
                inputSearchResultsPage.sendKeys(searchTerm);
                break;
        }
    }
}

