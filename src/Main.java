import cryptors.Cryptor;
import cryptors.CryptorCreator;

public class Main {
    public static void main(String[] args) {
        int key = 0;
        String in = null;
        String out = null;
        String data = null;
        String alg = "shift";
        String mode = "enc";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode"))
                mode = args[i + 1];
            if (args[i].equals("-key"))
                key = Integer.parseInt(args[i + 1]);
            if (args[i].equals("-in"))
                in = args[i + 1];
            if (args[i].equals("-out"))
                out = args[i + 1];
            if (args[i].equals("-data"))
                data = args[i + 1];
            if (args[i].equals("-alg"))
                alg = args[i + 1];
        }
        CryptorCreator cryptorCreator = new CryptorCreator(mode, data, in, out, key, alg);
        Cryptor cryptor = cryptorCreator.createCryptor();
        cryptor.work();
    }
}
