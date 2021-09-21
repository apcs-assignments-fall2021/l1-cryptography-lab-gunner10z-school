import java.util.Scanner;

public class Affine {
    public static String encryptAffine(String message) {
        String newMessage="";
        int key1=3;
        int key2=0;
        for(int i = 0; i<message.length(); i++) {
            char a = message.charAt(i);
            if ((a>='a'&&a<='z')||(a>='A'&&a<='Z')) {
                if (a >= 'a' && a <= 'z') {
                    a=(char)(a-'a');
                    a=(char)(((key1 * a) + key2) % 26);
                    a+='a';

                } else if (a >= 'A' && a <= 'Z') {
                    a=(char)(a-'A');
                    a=(char)(((key1 * a) + key2) % 26);
                    a+='A';

                }
                newMessage+=a;
            }
            else{
                newMessage+=a;
            }
        }
        return newMessage;
    }

    public static String decryptAffine(String message) {
        String newMessage="";
        int m=9;
        int key2=0;
        for(int i = 0; i<message.length(); i++) {
            char a = message.charAt(i);
            if ((a>='a'&&a<='z')||(a>='A'&&a<='Z')) {
                if (a >= 'a' && a <= 'z') {
                    a=(char)(a-'a');
                    a=(char)((m * (a - key2)) % 26 );
                    a+='a';

                } else if (a >= 'A' && a <= 'Z') {
                    a=(char)(a-'A');
                    a=(char)((m * (a - key2)) % 26 );
                    a+='A';

                }
                newMessage+=a;
            }
            else{
                newMessage+=a;
            }
        }
        return newMessage;
    }

    public static String encryptAffineKeys(String message, int key1, int key2) {
        // REPLACE THIS WITH YOUR CODE
        return message;
    }

    public static int modularInverse(int x) {
        int counter=0;
        while (true){
            counter++;
            if ((x * counter) % 26 == 1){
                return counter;
            }
        }
    }


    public static String decryptAffineKeys(String message, int key1, int key2) {
        // REPLACE THIS WITH YOUR CODE
        return message;
    }

    // Some basic testing code
    public static void main(String[] args) {
        System.out.println("Encrypt and Decrypt Basic Tests:");
        System.out.println(encryptAffine(("Hello, World!"))); // Vmhhq, Oqzhj!
        System.out.println(decryptAffine("Vmhhq, Oqzhj!")); // Hello, World!

        System.out.println();
        System.out.println("Modular Inverse Tests:");
        System.out.println(modularInverse(9)); // 3
        System.out.println(modularInverse(3)); // 9
        System.out.println(modularInverse(23)); // 17

        System.out.println();
        System.out.println("Affine Encrypt and Decrypt with Keys Tests:");
        System.out.println(encryptAffineKeys("hello", 5, 17)); // aluuj
        System.out.println(decryptAffineKeys("aluuj", 5, 17)); // hello
    }
}
