package pageObjects.DOTABuff.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MostUsedItemsComponent {
    @FindBy(xpath = "//header[contains(text(), 'Most Used Items')]/parent::section//tbody//tr//img")
    private List<WebElement> listTableMostUsedItems;

    public List<String> collectMostUsedItemNames() {
        System.out.println("[Action] - Collecting most used items table...");
        List<String> items = new ArrayList<>();
        for (WebElement element : listTableMostUsedItems) {
            items.add(element.getAttribute("oldtitle"));
        }
        return items;
    }
}
