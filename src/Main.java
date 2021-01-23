import encryptor.Encryptor;

public class Main {

    public static void main(String[] args) {
        String originalMessage = "we found a treasure!";
        System.out.println(Encryptor.encrypt(originalMessage));
    }
}
