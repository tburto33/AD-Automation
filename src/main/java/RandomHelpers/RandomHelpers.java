package RandomHelpers;

import java.util.List;
import java.util.Random;

public class RandomHelpers {

    public static String getRandomStringFromList(List<String> list) {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size() - 1);
        return list.get(randomIndex);
    }
}
