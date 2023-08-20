package ch01;

public class E09 {
    public static void Run() {
        String str1 = "str";
        String str2 = "st".concat("r");
        System.out.printf("The result of expression str1 != str2 is %s%n", str1 != str2);
        System.out.printf("The result of expression str1.equals(str2) is %s%n", str1.equals(str2));
        String str3 = "stR".replace('R', 'r');
        System.out.printf("The result of expression str1 != str3 is %s%n", str1 != str3);
        System.out.printf("The result of expression str1.equals(str3) is %s%n", str1.equals(str2));
        String str4 = "  str  ".trim();
        System.out.printf("The result of expression str1 != str4 is %s%n", str1 != str4);
        System.out.printf("The result of expression str1.equals(str4) is %s%n", str1.equals(str4));
    }
}
