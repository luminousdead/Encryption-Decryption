package encryptor;

public class Encryptor {
    // A aB bC cD dE eF fG gH hI iJ jK kL lM mN nO oP pQ qR rS sT tU uV vW wX xY yZ z
    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
    private static StringBuilder code = new StringBuilder(alphabet);
    private static StringBuilder codeReverse = new StringBuilder(alphabet).reverse();

    public static String encrypt(String originalMsg) {
        String encryptedString = "";
        for (int i = 0; i < originalMsg.length(); i++) {
            if (originalMsg.charAt(i) == ' ') {
                encryptedString += " ";
            } else if (originalMsg.charAt(i) == '!') {
                encryptedString += "!";
            } else {
                encryptedString += codeReverse.charAt(code.indexOf(String.valueOf(originalMsg.charAt(i))));
            }
        }

        return encryptedString;
    }
}
