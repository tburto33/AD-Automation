package dao.DOTAData;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class DOTAData {

    public static List<String> getMostPopularItemsByHero(Hero hero) {
        switch (hero) {
            case ARC_WARDEN:
                return getArcWardenPopularItems();
            case SNAP_FIRE:
                return getSnapFirePopularItems();
            case DROW_RANGER:
                return getDrowRangerPopularItems();
        }
        System.out.println("[ERROR] NO DATA FOUND FOR PROVIDED HERO: " + hero);
        return null;
    }

    private static List<String> getArcWardenPopularItems() {
        List<String> list = new ArrayList<>();
        list.add("Boots of Travel");
        list.add("Wraith Band");
        list.add("Mjollnir");
        return list;
    }

    private static List<String> getSnapFirePopularItems() {
        List<String> list = new ArrayList<>();
        list.add("Magic Wand");
        list.add("Arcane Boots");
        list.add("Bracer");
        return list;
    }

    private static List<String> getDrowRangerPopularItems() {
        List<String> list = new ArrayList<>();
        list.add("Wraith Band");
        list.add("Power Treads");
        list.add("Hurricane Pike");
        return list;
    }

    public static String getHeroURLByHeroName(Hero hero) {
        switch (hero) {
            case ARC_WARDEN:
                return "https://www.dotabuff.com/heroes/arc-warden";
            case SNAP_FIRE:
                return "https://www.dotabuff.com/heroes/snapfire";
            case DROW_RANGER:
                return "https://www.dotabuff.com/heroes/drow-ranger";
        }
        return null;
    }

    public static String navigateToURLBYHeroName(WebDriver driver, Hero hero) {
        String url = getHeroURLByHeroName(hero);
        driver.get(url);
        System.out.println("[ACTION] - Attempting to navigate to url: " + url);
        return url;
    }

    public enum Hero {
        ARC_WARDEN,
        DROW_RANGER,
        SNAP_FIRE;
    }
}
