package DotaData;

import java.util.HashMap;

public class DotaData {
    HashMap<Integer, String> arcWarden = new HashMap<>();
    HashMap<Integer, String> drowRanger = new HashMap<>();
    HashMap<Integer, String> snapFire = new HashMap<>();

    public HashMap<Integer, String> getDrowRanger() {
        return drowRanger;
    }

    public HashMap<Integer, String> getSnapFire() {
        return snapFire;
    }

    public HashMap<Integer, String> getArcWarden(){
        return arcWarden;
    }

public class DotaDataStorage{
        DotaData dotaData = new DotaData();

        public void arcWardenMap(String itemName){
            HashMap<Integer, String> arcWarden = dotaData.getArcWarden();
            arcWarden.put(1, itemName);
            arcWarden.put(2, itemName);
            arcWarden.put(3, itemName);
        }

        public void drowRangerMap(String itemName){
            HashMap<Integer, String> drowRanger = dotaData.getDrowRanger();
            drowRanger.put(1, itemName);
            drowRanger.put(2, itemName);
            drowRanger.put(3, itemName);
        }

        public void snapFireMap(String itemName){
            HashMap<Integer, String> snapFire = dotaData.getSnapFire();
            snapFire.put(1, itemName);
            snapFire.put(2, itemName);
            snapFire.put(3, itemName);
        }
}
}
