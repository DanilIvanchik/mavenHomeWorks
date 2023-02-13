package hw15;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class tryFile {
    public static void main(String[] args){
        try(BufferedReader myBuffer = new BufferedReader(new FileReader("src\\main\\resources\\peaceAndWar.txt"))) {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src\\main\\resources\\peaceAndWarOutput.txt"));
            List<Map.Entry<String,Long>> list = myBuffer.lines()
                    .flatMap(s -> Arrays.stream(s.split(" ")))
                    .filter(s -> s.length()>3)
                    .map(s -> s.toLowerCase()
                            .replace(".", "")
                            .replace(",","")
                            .replace("!", "")
                            .replace("?", "")
                            .replace("<<", "")
                            .replace(">>", "")
                            .replace(";", "")
                            .replace(":", "")
                            .replace("“", "")
                            .replace("-", "")
                            .replace("”", "")
                            .replace("‘", ""))
                    .filter(s -> !s.contains("Russia"))
                    .filter(s -> !s.contains("Russian"))
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .toList();

            myWriter.write(String.valueOf(list) + '\n');

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
