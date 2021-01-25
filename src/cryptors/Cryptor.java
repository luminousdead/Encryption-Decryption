package cryptors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Cryptor {
    private File file;
    protected char[] msg;
    protected String mode;
    protected String out;
    protected String output = "";
    protected int key;

    Cryptor(String originalMsg, int key, String mode, String out) {
        this.msg = originalMsg.toCharArray();
        this.key = key;
        this.mode = mode;
        this.out = out;
    }

    public void work() {
        String cryptString = "";
        switch (this.mode) {
            case "enc":
                cryptString = encrypt();
                break;
            case "dec":
                cryptString =  decrypt();
                break;
            default:
                cryptString = "Error!";
                break;
        }

        if (out == null) {
            System.out.println(cryptString);
        } else {
            // напечатать в файл sting
            file = new File(out);
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(cryptString);
            } catch (IOException e) {
                System.out.printf("An exception occurs %s", e.getMessage());
            }
        }
    }

    abstract String encrypt();
    abstract String decrypt();
}
