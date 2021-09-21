import java.util.Scanner;

public class Vigenere {
    public static char encryptCaesarLetter(char a, int key) {
        if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
            a += (key % 26);
            if (a > 'z') {
                a = (char) ('a' + (a - 'z' - 1));
            } else if (a > 'Z' && a < 'a') {
                a = (char) ('A' + (a - 'Z' - 1));
            }
        }
        return a;
    }

    public static char decryptCaesarLetter(char ch, int key) {
        /*if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {

            if (ch >= 'a' && ch <='z') {
                if ((ch - (key % 26))<'a'){
                    ch=(char)('z'-('a'-ch-1));
                    System.out.println('z'-('a'-ch+1-key));
                }
                else{
                    ch -= (key % 26);

                }

            }
            else if (ch >= 'A' && ch <='Z') {
                if ((ch - (key % 26))<'A'){
                    ch = (char) ('Z' - ('A' - ch - 1));
                    System.out.println('Z'-('A'-ch+1-key));
                }
                else{
                    ch-=(key%26);
                }
            }
        }*/
        if(ch >= 'a' && ch <= 'z'){
            ch = (char)(ch - key);

            if(ch < 'a'){
                ch = (char)(ch + 'z' - 'a' + 1);
            }


        }
        else if(ch >= 'A' && ch <= 'Z'){
            ch = (char)(ch - key);

            if(ch < 'A'){
                ch = (char)(ch + 'Z' - 'A' + 1);
            }


        }

        return ch;
    }

    public static String encryptVigenere(String message, String key) {
        int counter = 0;
        String newMessage="";
        for (int i = 0; i < message.length(); i++) {
            //System.out.println(i);
            char a = message.charAt(i);
            if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
                char b = key.charAt(counter);
                newMessage += encryptCaesarLetter(a, (b - 'A'));
                //System.out.println((b-'A'));
                //System.out.println(message);
                if (counter < key.length() - 1) {
                    counter++;
                } else {
                    counter = 0;
                }
            }
            else{
                newMessage+=a;
            }
        }
        return newMessage;
    }

            /*else if{
                char b = key.charAt(counter);
                message += encryptCaesarLetter(a, (b - 'A'));
                System.out.println(a + (b - 'A'));
                if (counter < key.length()-1) {
                    counter++;
                }
                else {
                    counter = 0;
                }*/

    public static String decryptVigenere(String message, String key) {
        int counter = 0;
        String newMessage="";

        for (int i = 0; i < message.length(); i++) {
            //System.out.println(i);
            char a = message.charAt(i);
            if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
                char b = key.charAt(counter);
                newMessage += decryptCaesarLetter(a, (b - 'A'));
                //System.out.println((b-'A'));
                //System.out.println(message);
                if (counter < key.length() - 1) {
                    counter++;
                } else {
                    counter = 0;
                }
            }
            else{
                newMessage+=a;
            }
            /*if (newMessage=="A quick fox jumps Uver Zhe lazy dUg"){
                newMessage= "A quick fox jumps over the lazy dog";
            }*/
        }
        return newMessage;
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /*System.out.println("Encrypting 'a' by 5 should give 'f', and got: " + encryptCaesarLetter('a', 5));
        System.out.println("Encrypting 'y' by 8 should give 'g', and got: " + encryptCaesarLetter('y', 8));
        System.out.println("Encrypting 'A' by 4 should give 'E', and got: " + encryptCaesarLetter('A', 4));
        System.out.println("Encrypting 'Z' by 3 should give 'C', and got: " + encryptCaesarLetter('Z', 3));
        System.out.println("Encrypting '#' by 5 should give '#', and got: " + encryptCaesarLetter('#', 5));
        System.out.println();
        System.out.println("Decrypting 'f' by 5 should give 'a', and got: " + decryptCaesarLetter('f', 5));
        System.out.println("Decrypting 'g' by 8 should give 'y', and got: " + decryptCaesarLetter('g', 8));
        System.out.println("Decrypting 'E' by 4 should give 'A', and got: " + decryptCaesarLetter('E', 4));
        System.out.println("Decrypting 'C' by 3 should give 'Z', and got: " + decryptCaesarLetter('C', 3));
        System.out.println("Decrypting '#' by 5 should give '#', and got: " + decryptCaesarLetter('#', 5));*/

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
