public class Authenticator {
    public static boolean checkAdmin(String name) {
        // BUG 3: Logical Error. Compares memory addresses instead of string content.
        // Even if the user magically typed "admin", this would return false.
        if (name == "admin") {
            System.out.println("Admin access granted.");
            return true;
        } else {
            System.out.println("Standard student access.");
            return false;
        }
    }
}