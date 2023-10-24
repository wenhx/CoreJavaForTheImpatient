package ch08.e06;

public class E06 {
    public static void run() {
        String str1 = "123abd";
        String str2 = "example";
        System.out.printf("%s is a word? %s%n", str1, isWord(str1));
        System.out.printf("%s is a word? %s%n", str2, isWord(str2));
        String javaIdentifier1 = "test";
        String javaIdentifier2 = "1test";
        System.out.printf("%s is a java identifier? %s%n", javaIdentifier1, isValidJavaIdentifier(javaIdentifier1));
        System.out.printf("%s is a java identifier? %s%n", javaIdentifier2, isValidJavaIdentifier(javaIdentifier2));
    }

    public static boolean isWord(String str) {
        return str.codePoints().allMatch(i -> Character.isAlphabetic(i));
    }

    public static boolean isValidJavaIdentifier(String str) {
        return str.codePoints().limit(1).allMatch(i -> Character.isJavaIdentifierStart(i)) &&
                str.codePoints().skip(1).allMatch(i -> Character.isJavaIdentifierStart(i));
    }
}
