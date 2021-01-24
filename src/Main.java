import encryptor.EncryptorDecryptor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int key = 0;
        String in = null, workStyle = "enc", out = null, data = null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode"))
                workStyle = args[i+1];
            if (args[i].equals("-key"))
                key = Integer.parseInt(args[i+1]);
            if (args[i].equals("-in"))
                in = args[i+1];
            if (args[i].equals("-out"))
                out = args[i+1];
            if (args[i].equals("-data"))
                data = args[i+1];
        }

        String answer = "";
        File file;
        if (data != null) {
            if (out == null) {
                answer = EncryptorDecryptor.work(data, key, workStyle);
                System.out.println(answer);
            } else {
                answer = EncryptorDecryptor.work(data, key, workStyle);
                file = new File(out);
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(answer);
                } catch (IOException e) {
                    System.out.printf("An exception occurs %s", e.getMessage());
                }
            }
        } else if (in != null) {
            data = "";
            file = new File(in);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    data += scanner.nextLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("No file found: " + in);
            }

            if (out == null) {
                answer = EncryptorDecryptor.work(data, key, workStyle);
                System.out.println(answer);
            } else {
                answer = EncryptorDecryptor.work(data, key, workStyle);
                file = new File(out);
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(answer);
                } catch (IOException e) {
                    System.out.printf("An exception occurs %s", e.getMessage());
                }
            }
        } else {
            System.out.println(answer);
        }
    }
}
