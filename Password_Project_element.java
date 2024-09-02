import java.util.*;
import java.io.Console;
class Main {
    public static void main(String[] args) {
        Console console = System.console();
        
        if (console == null) {
            System.out.println("No console available");
            System.exit(1);
        }
        char[] passwordChars = readPassword(console, "Enter your password: ");
        String password = new String(passwordChars);
        System.out.println("\nYou entered: " + password);
        validatePassword(password);
    }
    private static char[] readPassword(Console console, String prompt) {
        StringBuilder password = new StringBuilder();
        System.out.print(prompt);
        while (true) {
            char[] input = console.readPassword("");
            if (input.length > 0) {
                for (char c : input) {
                    password.append(c);
                    System.out.print("*");
                }
            }
            return password.toString().toCharArray();
        }
    }

    private static void validatePassword(String password) {
        int minLength = 8, maxLength = 20;
        int u = 0, l = 0, d = 0, special = 0;

        if (password.length() < minLength || password.length() > maxLength) {
            System.out.println("Password must be between " + minLength + " and " + maxLength + " characters long.");
            return;
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))
                u++;
            else if (Character.isLowerCase(c))
                l++;
            else if (Character.isDigit(c))
                d++;
            else if (!Character.isLetterOrDigit(c)) // Check for special characters
                special++;
        }
        if (u > 0 && l > 0 && d > 0 && special > 0) {
            System.out.println("Password accepted.");
        } else {
            System.out.println("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
        }
    }
}
