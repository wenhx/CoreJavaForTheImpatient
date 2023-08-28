package ch01;

import java.util.Scanner;

public class E07 {
    public static void run() {
        System.out.printf("The max value of short is %d%n", Short.MAX_VALUE);
        System.out.printf("The next of Short.MAX_VALUE is %d", (short)(Short.MAX_VALUE + 1));
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入第一个数（0~65535）：");
        short num1 = (short) (scanner.nextInt() & 0xFFFF);

        System.out.print("请输入第二个数（0~65535）：");
        short num2 = (short) (scanner.nextInt() & 0xFFFF);

        // 无符号之和
        int sum = (num1 & 0xFFFF) + (num2 & 0xFFFF);
        System.out.println("无符号之和：" + sum);

        // 无符号之差
        int diff = (num1 & 0xFFFF) - (num2 & 0xFFFF);
        System.out.println("无符号之差：" + diff);

        // 无符号之积
        int product = ((num1 & 0xFFFF) * (num2 & 0xFFFF)) & 0xFFFF;
        System.out.println("无符号之积：" + product);

        // 无符号之商
        int quotient = ((num1 & 0xFFFF) / (num2 & 0xFFFF)) & 0xFFFF;
        System.out.println("无符号之商：" + quotient);

        // 无符号余数
        int remainder = ((num1 & 0xFFFF) % (num2 & 0xFFFF)) & 0xFFFF;
        System.out.println("无符号余数：" + remainder);
    }
}
