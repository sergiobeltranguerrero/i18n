package christmas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GiftList {
    private File giftListFile;
    private Map <String, Integer> giftList;

    public GiftList() {
        this.giftList = new HashMap<>();
    }

    public GiftList(String path) {
        this.giftListFile = new File(path);
        giftList = new HashMap<>();
    }

    public void setGiftListFile(String path) {
        this.giftListFile = new File(path);
    }

    private void addGift(String giftName) {
        if (giftList.containsKey(giftName)) {
            giftList.put(giftName, giftList.get(giftName) + 1);
        } else {
            giftList.put(giftName, 1);
        }
    }

    public void readGiftsFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(giftListFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            addGift(line.toLowerCase());
        }
        scanner.close();
    }

    public void printGiftList() {
        for (String giftName : giftList.keySet()) {
            System.out.println(giftName + ": " + giftList.get(giftName));
        }
    }
}
