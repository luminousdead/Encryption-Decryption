package cryptors;

public class ShiftCryptor extends Cryptor{
    ShiftCryptor(String originalMsg, int key, String mode, String out) {
        super(originalMsg, key, mode, out);
    }
    private String alphabetUp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String alphabetLow = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();

    @Override
    String encrypt() {
        for (int i = 0; i < msg.length; i++) {
            if (!alphabetLow.contains(String.valueOf(msg[i]).toLowerCase()))
            {
                output += msg[i];
                continue;
            }

            int tmpX = alphabetUp.indexOf(String.valueOf(msg[i]).toUpperCase());
            for (int j = 0; j < key; j++) {
                tmpX += 1;
                if (tmpX == alphabetUp.length())
                    tmpX = 0;
            }

            if (Character.isUpperCase(msg[i])) {
                output += alphabetUp.charAt(tmpX);
            } else {
                output += alphabetLow.charAt(tmpX);
            }
        }
        return output;
    }

    @Override
    String decrypt() {
        for (int i = 0; i < msg.length; i++) {
            if (!alphabetLow.contains(String.valueOf(msg[i]).toLowerCase()))
            {
                output += msg[i];
                continue;
            }

            int tmpX = alphabetUp.indexOf(String.valueOf(msg[i]).toUpperCase());
            for (int j = 0; j < key; j++) {
                tmpX -= 1;
                if (tmpX == -1)
                    tmpX = alphabetUp.length() - 1;
            }

            if (Character.isUpperCase(msg[i])) {
                output += alphabetUp.charAt(tmpX);
            } else {
                output += alphabetLow.charAt(tmpX);
            }
        }
        return output;
    }
}
