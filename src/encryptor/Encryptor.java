package encryptor;

public class Encryptor {
    // abcdefghijklmnopqrstuvwxyz
    // A aB bC cD dE eF fG gH hI iJ jK kL lM mN nO oP pQ qR rS sT tU uV vW wX xY yZ z
    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
    private static StringBuilder code = new StringBuilder(alphabet);
//    private static StringBuilder codeChangedByKey = new StringBuilder(alphabet);

    public static String encrypt(String originalMsg, int key) {
        String encryptedString = "";
        String alphabetChangedByKey = alphabet.substring(key) + alphabet.substring(0, key);
        for (int i = 0; i < originalMsg.length(); i++) {
            if (alphabet.contains(String.valueOf(originalMsg.charAt(i)))) {
                encryptedString += alphabetChangedByKey.charAt(alphabet.indexOf(String.valueOf(originalMsg.charAt(i))));
            } else {
                encryptedString += originalMsg.charAt(i);
            }
        }

        return encryptedString;
    }
}
