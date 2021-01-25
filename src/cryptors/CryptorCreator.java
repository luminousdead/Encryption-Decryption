package cryptors;

public class CryptorCreator extends CryptorFactory {
    public CryptorCreator(String mode, String data, String in, String out, int key, String alg) {
        super(mode, data, in, out, key, alg);
    }

    @Override
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
