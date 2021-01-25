package cryptors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CryptorFactory {
    private String mode;
    private String data;
    private String in;
    private String out;
    private String alg;
    private int key;
    private File file;

    public CryptorFactory(String mode, String data, String in, String out, int key, String alg) {
        this.alg = alg;
        this.mode = mode;
        this.data = data;
        this.in = in;
        this.out = out;
        this.key = key;
    }

    protected String getData() {
        if (data == null)
        {
            data = "";
            try {
                file = new File(in);
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNext()) {
                        data += scanner.nextLine();
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("No file found: " + in);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return data;
    }
    protected int getKey() {
        return this.key;
    }
    protected String getAlg() {
        return this.alg;
    }
    protected String getMode() {
        return this.mode;
    }
    protected String getOut() {
        return this.out;
    }

    public Cryptor createCryptor() {
        switch (getAlg()) {
            case "shift":
                return new ShiftCryptor(getData(), getKey(), getMode(), getOut());
            case "unicode":
                return new UnicodeCryptor(getData(), getKey(), getMode(), getOut());
            default:
                return null;
        }
    }
}