package cryptors;

public class UnicodeCryptor extends Cryptor {
    UnicodeCryptor(String originalMsg, int key, String mode, String out) {
        super(originalMsg, key, mode, out);
    }

    @Override
    String decrypt() {
        for (int i = 0; i < msg.length; i++) {
            output += Character.toString(msg[i] - key);
        }
        return output;
    }
    @Override
    String encrypt() {
        for (int i = 0; i < msg.length; i++) {
            output += Character.toString(msg[i] + key);
        }
        return output;
    }
}
