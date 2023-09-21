import java.util.Scanner;

public class ModCaesar {
    public static final int ALPHASIZE = 26;
    public static final char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
        'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    protected char[] encrypt = new char[ALPHASIZE];
    protected char[] decrypt = new char[ALPHASIZE];

    public ModCaesar() {
        for (int i = 0; i < ALPHASIZE; i++)
            encrypt[i] = alpha[(i + 3) % ALPHASIZE];
        for (int i = 0; i < ALPHASIZE; i++)
            decrypt[encrypt[i] - 'A'] = alpha[i];
    }

    public String encrypt(String secret) {
        char[] mess = secret.toCharArray();
        for (int i = 0; i < mess.length; i++)
            if (Character.isUpperCase(mess[i]))
                mess[i] = encrypt[mess[i] - 'A'];
        return new String(mess);
    }

    public String decrypt(String secret) {
        char[] mess = secret.toCharArray();
        for (int i = 0; i < mess.length; i++)
            if (Character.isUpperCase(mess[i]))
                mess[i] = decrypt[mess[i] - 'A'];
        return new String(mess);
    }

    public static void main(String[] args) {
        ModCaesar cipher = new ModCaesar();
        System.out.println("Encryption order = " + new String(cipher.encrypt));
        System.out.println("Decryption order = " + new String(cipher.decrypt));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message to encrypt: ");
        String message = scanner.nextLine();
        String encryptedMessage = cipher.encrypt(message);
        System.out.println("Encrypted message: " + encryptedMessage);

        System.out.print("Enter a message to decrypt: ");
        message = scanner.nextLine();
        String decryptedMessage = cipher.decrypt(message);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
