import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String newMessage="";
        for(int i = 0; i<message.length(); i++) {
            char a = message.charAt(i);
            if ((a>='a'&&a<='z')||(a>='A'&&a<='Z')) {
                a+=3;
                if (a>'z'){
                    a=(char)('a'+(a-'z'-1));
                }
                else if(a>'Z'&&a<'a'){
                    a=(char)('A'+(a-'Z'-1));
                }
            }
            newMessage+=a;

        }
        return newMessage;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String newMessage="";
        for(int i = 0; i<message.length(); i++) {
            char a = message.charAt(i);
            if ((a>='a'&&a<='z')||(a>='A'&&a<='Z')) {
                a-=3;
                if (a<'a'&&a>'Z'){
                    a=(char)('z'-('a'-a-1));
                }
                else if(a<'A'){
                    a=(char)('Z'-('A'-a-1));
                }
            }

            newMessage+=a;

        }
        return newMessage;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String newMessage="";
        for(int i = 0; i<message.length(); i++) {
            char a = message.charAt(i);
            if ((a>='a'&&a<='z')||(a>='A'&&a<='Z')) {
                a+=(key%26);
                if (a>'z'){
                    a=(char)('a'+(a-'z'-1));
                }
                else if(a>'Z'&&a<'a'){
                    a=(char)('A'+(a-'Z'-1));
                }
            }
            newMessage+=a;

        }
        return newMessage;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String newMessage="";
        for(int i = 0; i<message.length(); i++) {
            char a = message.charAt(i);
            if ((a>='a'&&a<='z')||(a>='A'&&a<='Z')) {
                a-=(key%26);
                if (a<'a'&&a>'Z'){
                    a=(char)('z'-('a'-a-1));
                }
                else if(a<'A'){
                    a=(char)('Z'-('A'-a-1));
                }
            }

            newMessage+=a;

        }
        return newMessage;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();
//
        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter your key to be used: ");
            int key = scan.nextInt();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesarKey(message,key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter your key to be used: ");
            int key = scan.nextInt();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesarKey(message,key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
