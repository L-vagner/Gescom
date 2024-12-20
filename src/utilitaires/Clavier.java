package utilitaires;


import java.util.Scanner;

public class Clavier {
    private static Scanner scanner = new Scanner(System.in);

    public static int saisie_int(String message) {
        System.out.print(message);
        int intUser = scanner.nextInt();
        System.out.print('\n');
        return intUser;
    }

    public static String saisie_string(String message) {
        System.out.print(message);
        String stringUser = scanner.next();
        System.out.print('\n');
        return stringUser;
    }
}
