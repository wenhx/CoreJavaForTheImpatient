package ch07.e07;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class E07 {
    public static void run() {
        String fileNmae = "src\\ch07\\e07\\View.txt";
        TreeMap<String, Integer> counters = new TreeMap<>();
        try (FileReader fileReader = new FileReader(fileNmae)) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int ch = fileReader.read();
                if (ch == -1)
                    break;

                if (Character.isLetter(ch)) { // For simplicity, let's only consider words that consist of letters.
                    sb.append((char)ch);
                } else {
                    if (sb.length() == 0) {
                        continue;
                    } else {
                        String word = sb.toString();
                        counters.merge(word, 1, Integer::sum);
                        sb.setLength(0);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(counters.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: %d%n", list.get(i).getKey(), list.get(i).getValue());
        }
    }
}
