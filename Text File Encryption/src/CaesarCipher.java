import java.io.*;
import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the key for encryption and decryption: ");
        int key = scanner.nextInt();

        encryptFile(filePath, key);
        decryptFile(filePath, key);

        scanner.close();
    }

    private static void encryptFile(String filePath, int key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Nikhil Reddy/IdeaProjects/Text File Encryption/src/encrypted_nikhil.txt"))) {

            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                char encryptedChar = encryptChar((char) currentChar, key);
                writer.write(encryptedChar);
            }

            System.out.println("File encrypted successfully!");

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }


    private static void decryptFile(String filePath, int key) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Nikhil Reddy/IdeaProjects/Text File Encryption/src/encrypted_nikhil.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Nikhil Reddy/IdeaProjects/Text File Encryption/src/decrypted_nikhil.txt"))) {

            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                char decryptedChar = decryptChar((char) currentChar, key);
                writer.write(decryptedChar);
            }

            System.out.println("File decrypted successfully!");

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }


    private static char encryptChar(char ch, int key) {
        if (Character.isUpperCase(ch)) {
            return (char) ((ch + key - 'A') % 26 + 'A');
        } else if (Character.isLowerCase(ch)) {
            return (char) ((ch + key - 'a') % 26 + 'a');
        } else {
            return ch;
        }
    }

    private static char decryptChar(char ch, int key) {
        if (Character.isUpperCase(ch)) {
            return (char) ((ch - key - 'A' + 26) % 26 + 'A');
        } else if (Character.isLowerCase(ch)) {
            return (char) ((ch - key - 'a' + 26) % 26 + 'a');
        } else {
            return ch;
        }
    }
}
