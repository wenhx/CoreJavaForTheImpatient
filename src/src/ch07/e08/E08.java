package ch07.e08;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class E08 {
    public static void run() {
        String fileNmae = "src\\ch07\\e07\\View.txt";
        HashMap<String, Set<Integer>> wordRecords = new HashMap<>();
        int currentLine = 0;
        try (FileReader fileReader = new FileReader(fileNmae)) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int ch = fileReader.read();
                if (ch == -1)
                    break;

                if (Character.isLetter(ch)) { // For simplicity, let's only consider words that consist of letters.
                    sb.append((char)ch);
                } else if (ch == '\r') {
                    currentLine++;
                } else {
                    if (sb.length() == 0) {
                        continue;
                    } else {
                        String word = sb.toString();
                        Set<Integer> wordsInLines;
                        if (wordRecords.containsKey(word)) {
                            wordsInLines = wordRecords.get(word);
                        } else {
                            wordsInLines = new TreeSet<>();
                            wordRecords.put(word, wordsInLines);
                        }
                        wordsInLines.add(currentLine);
                        sb.setLength(0);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Map.Entry<String, Set<Integer>>> list = new ArrayList<>(wordRecords.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getValue().size() - e1.getValue().size());
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: ", list.get(i).getKey());
            for (Integer line : list.get(i).getValue()) {
                System.out.printf("%d, ", line);
            }
            System.out.println();
        }
    }
}
