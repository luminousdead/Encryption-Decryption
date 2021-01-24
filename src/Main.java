import encryptor.Encryptor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int key = scanner.nextInt();
        System.out.println(Encryptor.encrypt(input, key));
    }
}
