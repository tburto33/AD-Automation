import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DDGData {

    public static void main(String args[]) {

        List<String> searchTerms = new ArrayList<>();
        searchTerms.add("Baby Ferret Pictures");
        searchTerms.add("Home Gardening");
        searchTerms.add("How to hit immortal DOTA2");
        searchTerms.add("Stackoverflow helped me again");
        searchTerms.add("Bearded Dragon Pictures");

        Random random = new Random();
        int randomIndex = random.nextInt(searchTerms.size() -1);
        String randomTerm1 = searchTerms.get(randomIndex);
        Collections.shuffle(searchTerms);
        String randomTerm2 = searchTerms.get(randomIndex);
    }



}
