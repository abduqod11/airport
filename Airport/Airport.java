package Airport;
/*
 *User:t.me/abu_org tt:@abu_ed1t
 *Date:21.10.2023 *Time:18:43
 */

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Airport {
    static ArrayList<Line> lines = new ArrayList<>();
    static Scanner strScanner = new Scanner(System.in);
    static Scanner intScanner = new Scanner(System.in);
    static Scanner str2Scanner = new Scanner(System.in);
    static String[] log = {"qwerty@gmail.com", "asdfg112@gamil.com", "erghs34@gamil.com"};
    static String[] password = {"qwe123", "esd0929", "ersim8103"};

    static String[] regions = {"Toshkent", "Toshkent viloyati", "Andijon viloyati", "Farg'ona viloyati", "Namangan viloyati", "Sirdaryo viloyati",
            "Jizzax viloyati", "Samarqand viloyati", "Surxandaryo viloyati", "Qashqadaryo viloyati", "Buxoro viloyati", "Navoiy viloyati",
            "Xorazm viloyati", "Qoraqalpog'iston respublikasi"};

    public static void main(String[] args) {
        System.out.print("Akkauntga kirish: ");
        String loginAcc = strScanner.next();
        System.out.print("Parolni kiriting: ");
        String passwordMenu = strScanner.next();
        boolean bool = false;
        for (int i = 0; i < log.length; i++) {
            if (loginAcc.equals(log[i]) && passwordMenu.equals(password[i])) {
                bool = true;
                getreaces();
                System.out.println("                                                              ✈️Xush kelibsiz✈️");
                System.out.println("                           Siz O'zbekiston havo yoʻllari \uD83C\uDF10onlayn saytiga tashrif buyurganingizdan bag'oyatda xursandmiz❗");
                while (true) {
                    System.out.println("""
                            0. Chiqish
                            1. Barcha reyslar ko'rish 
                            2. Chipta olish🎫 
                            3. Biz bilan bog'lanish☎️
                            """);
                    int tanla = intScanner.nextInt();
                    if (tanla == 0) break;
                    switch (tanla) {
                        case 1 -> menuRaces();
                        case 2 -> checkOut();
                        case 3 -> lineWithMe();
                    }
                }
            }
            if (bool == false)
                System.out.println("Email yoki parolda xatolik mavjud,iltimos qayta tekshirib kiriting!");
            break;
        }
    }

    private static void getreaces() {
        int k = 1;
        int oy = 6;
        for (int i = 0; i < regions.length; i++) {
            for (int j = 0; j < regions.length; j++) {
                if (oy < 10) {
                    if (i != j) {
                        int price = (int) (Math.random() * 200 + 50);
                        Line line;
                        if (k + 1 < 10) {
                            line = new Line(regions[i], regions[j], "0" + k + "/" + "0" + oy + "/2023", "0" + (k + 1) + "/" + "0" + oy + "/2023", price);
                        } else if (k == 9) {
                            line = new Line(regions[i], regions[j], "0" + k + "/" + "0" + oy + "/2023", (k + 1) + "/" + "0" + oy + "/2023", price);
                        } else {
                            line = new Line(regions[i], regions[j], k + "/" + "0" + oy + "/2023", (k + 1) + "/" + "0" + oy + "/2023", price);
                        }
                        lines.add(line);
                        k++;
                        if (k == 28) {
                            k = 1;
                            oy++;
                        }
                    }
                } else {
                    if (i != j) {
                        int price = (int) (Math.random() * 200 + 50);
                        Line line;
                        if (k + 1 < 10) {
                            line = new Line(regions[i], regions[j], "0" + k + "/" + oy + "/2023", "0" + (k + 1) + "/" + oy + "/2023", price);
                        } else if (k == 9) {
                            line = new Line(regions[i], regions[j], "0" + k + "/" + oy + "/2023", (k + 1) + "/" + oy + "/2023", price);
                        } else {
                            line = new Line(regions[i], regions[j], k + "/" + oy + "/2023", (k + 1) + "/" + oy + "/2023", price);
                        }
                        lines.add(line);
                        k++;
                        if (k == 28) {
                            k = 1;
                            oy++;
                        }
                    }
                }
            }
        }
    }

    private static void menuRaces() {
        while (true) {
            System.out.println("""
                    0. Chiqish
                    1. Hamma reyslarni ko'rish
                    2. Viloyatlar aro reyslar
                    3. Sana bo'yicha qidirish
                    """);
            int tanla = intScanner.nextInt();
            if (tanla == 0) break;
            switch (tanla) {
                case 1 -> allRaces();
                case 2 -> oneRegion();
                case 3 -> searchDate();
            }
        }
    }

    private static void checkOut() {
        boolean check = false;
        while (true) {
            System.out.println("""
                    0. Chiqish
                    1. Chipta sotib olish🎫
                    """);
            int tanla = intScanner.nextInt();
            if (tanla == 0) break;
            if (tanla == 1) {
                System.out.print("Ismingizni kiriting: ");
                String firstname = strScanner.next();
                System.out.print("Familiyangizni kiriting: ");
                String surname = strScanner.next();
                System.out.print("Tug'ulgan yilingizni kiriting: ");
                int year = intScanner.nextInt();
                System.out.print("Qaysi viloyatdan bormoqchisiz: ");
                String origin = str2Scanner.nextLine();
                System.out.print("Qaysi viloyatga bormoqchisiz: ");
                String destination = str2Scanner.nextLine();
                for (int i = 0; i < lines.size(); i++) {
                    if ((Objects.equals(lines.get(i).getOrigin().toLowerCase(), origin.toLowerCase())) &&
                            (Objects.equals(lines.get(i).getDestination().toLowerCase(), destination.toLowerCase()))) {

                        System.out.println("------------------------------\n" +
                                "Ismingiz: " + firstname + "\n" +
                                "Familiyangiz: " + surname + "\n" +
                                "Yoshingiz: " + (2023 - year) + "\n" +
                                "Qayerdan: " + origin + "\n" +
                                "qayerga: " + destination + "\n" +
                                "Ketish: " + lines.get(i).getDeparture() + "\n" +
                                "Chipta narxi: " + lines.get(i).getPrice() + "$\n------------------------------");
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    System.out.println("Malumotni tog'ri kiriting");
                } else {
                    break;
                }
            }
        }
    }

    private static void allRaces() {
        for (int i = 0; i < lines.size(); i++) {
            String row1 = lines.get(i).getOrigin();
            String row2 = lines.get(i).getDestination();
            String date1 = lines.get(i).getDeparture();
            String date2 = lines.get(i).getWreturn();
            System.out.printf("%-33s %-33s %-15s %-6s%n", row1, row2, date1, date2);
        }
    }

    private static void oneRegion() {
        while (true) {
            boolean check = false;
            System.out.println("""
                    0. Chiqish
                    1. Shahar tanlash
                    """);
            int tanla = intScanner.nextInt();
            if (tanla == 0) break;
            if (tanla == 1) {
                System.out.print("Shahar kiriting: ");
                String place = (new Scanner(System.in)).nextLine();
                 for (int i = 0; i < lines.size(); i++) {
                    if (Objects.equals(lines.get(i).getOrigin().toLowerCase(), place.toLowerCase())) {
                        check = true;
                        String row1 = lines.get(i).getOrigin();
                        String row2 = lines.get(i).getDestination();
                        String date1 = lines.get(i).getDeparture();
                        String date2 = lines.get(i).getWreturn();
                        System.out.printf("%-33s %-33s %-15s %-6s%n", row1, row2, date1, date2);
                    }
                }
//                    if (!check) System.out.println("Bunday viloyat mavjud emas");
            }
            if (check) break;
        }
    }

    private static void searchDate() {
        boolean check = false;
        while (true) {
            System.out.println("""
                    0. Chiqish
                    1. Sana kiritish
                    """);
            int tanla = intScanner.nextInt();
            if (tanla == 0) break;
            if (tanla == 1) {
                System.out.print("Sana kiriting: ");
                String date = strScanner.next();
                for (int i = 0; i < lines.size(); i++) {
                    if (Objects.equals(lines.get(i).getDeparture(), date)) {
                        check = true;
                        String row1 = lines.get(i).getOrigin();
                        String row2 = lines.get(i).getDestination();
                        String date1 = lines.get(i).getDeparture();
                        String date2 = lines.get(i).getWreturn();
                        System.out.printf("%-33s %-33s %-15s %-6s%n", row1, row2, date1, date2);
                    }
                }
                if (!check) System.out.println("Bunday sanadagi reys mavjud emas");
            }
            if (check) break;
        }
    }

    private static void lineWithMe() {
        while (true) {
            System.out.print("Nomer kiriting: ");
            long number = intScanner.nextLong();
            if (number >= 10) {
                System.out.println("Sizning telefon raqamingizga sms kod yuborildi");
                int sentCode = (int) (Math.random() * 10000);
                System.out.println("Sizning kodingiz: " + sentCode);
                System.out.print("Sms kodingizni kiriting: ");
                int enterCode = intScanner.nextInt();
                if (enterCode == sentCode) {
                    System.out.println("Siz bilan qisqa vaqtlarda aloqaga chiqamiz");
                } else System.out.println("Sms kodini xato kiritingiz, tekshirib qayta kiriting");
            } else System.out.println("Telefon raqami xato kiritildi");
            break;
        }
    }
}