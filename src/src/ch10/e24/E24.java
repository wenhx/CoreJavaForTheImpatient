package ch10.e24;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E24 {
    public static void run() {
        System.out.print("Please input a url: ");
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        CompletableFuture.supplyAsync(() -> readPage(url))
                .thenApply(E24::parseLink)
                .thenAccept(E24::displayLinks);
        System.out.println("Main thread done!");
        ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
    }

    public static String readPage(String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            int c;
            StringBuilder sb = new StringBuilder();
            try (InputStreamReader reader = new InputStreamReader(conn.getInputStream())) {
                while ((c = reader.read()) != -1) {
                    sb.append((char) c);
                }
            }
            System.out.println("Download finished!");
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> parseLink(String page) {
        String regex = "<a\\b[^>]*>(.*?)</a>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(page);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        System.out.println("Parse finished!");
        return list;
    }

    public static CompletableFuture<Void> displayLinks(List<String> links) {
        return CompletableFuture.runAsync(() -> {
            links.forEach(System.out::println);
        });
    }
}
