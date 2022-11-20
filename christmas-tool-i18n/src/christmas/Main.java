package christmas;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    static final ResourceBundle i18n
            = ResourceBundle.getBundle("christmas.i18n.translations");
    static final Scanner scanner
            = new Scanner(System.in);

    static boolean isFinished = false;

    static GiftList giftList = new GiftList();

    public static void main(String[] args) {
        System.out.println(i18n.getString("WELCOME"));
        System.out.println(i18n.getString("DESCRIPTION"));

        while (!isFinished) {
            System.out.println(i18n.getString("USAGE"));
            System.out.println("\t" + i18n.getString("OPTION1"));
            System.out.println("\t" + i18n.getString("OPTION2"));
            System.out.println("\t" + i18n.getString("OPTION3"));
            System.out.println("\t" + i18n.getString("EXIT"));


            System.out.print(i18n.getString("CHOICE"));
            String input = scanner.nextLine();
            System.out.println();

            switch (input) {
                case "1" -> {
                    System.out.print(i18n.getString("GET_PATH_FILE"));
                    String path = scanner.nextLine();
                    giftList.setGiftListFile(path);
                    try {
                        System.out.println(i18n.getString("READING_FILE"));
                        giftList.readGiftsFile();
                    } catch (Exception e) {
                        System.out.println(i18n.getString("ERROR"));
                        System.out.println(e.getMessage());
                        return;
                    }
                }
                case "2" -> {
                    System.out.println(i18n.getString("RESULT"));
                    System.out.println(" ");
                    System.out.println("******************");
                    giftList.printGiftList();
                    System.out.println("******************");
                }
                case "3" -> {
                    // days until Christmas
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String inputString1 = "25/12/2022";
                    LocalDate now = LocalDate.now();
                    LocalDate christmas = LocalDate.parse(inputString1, dtf);
                    long days = ChronoUnit.DAYS.between(now, christmas);
                    System.out.println(MessageFormat.format(i18n.getString("DAYS_UNTIL_CHRISTMAS"), days));

                }
                case "4" -> isFinished = true;
            }
            System.out.println("\n\n");
        }
    }
}
