package encryptor;

public class EncryptorDecryptor {
    // abcdefghijklmnopqrstuvwxyz
    // A aB bC cD dE eF fG gH hI iJ jK kL lM mN nO oP pQ qR rS sT tU uV vW wX xY yZ z
    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
//    private static StringBuilder code = new StringBuilder(alphabet);
//    private static StringBuilder codeChangedByKey = new StringBuilder(alphabet);

    public static String work(String originalMsg, int key, String workStyle) {
        if (workStyle.equals("enc"))
            return encrypt(originalMsg, key);
        else if (workStyle.equals("dec"))
            return decrypt(originalMsg, key);
        else
            return "Error!";
    }

    private static String encrypt (String originalMsg, int key) {
        String output = "";
        char[] msg = originalMsg.toCharArray();
        for (int i = 0; i < originalMsg.length(); i++) {
            output += Character.toString(msg[i] + key);
        }
        return output;
    }

    private static String decrypt (String originalMsg, int key) {
        String output = "";
        char[] msg = originalMsg.toCharArray();
        for (int i = 0; i < originalMsg.length(); i++) {
            output += Character.toString(msg[i] - key);
        }
        return output;
    }
}
