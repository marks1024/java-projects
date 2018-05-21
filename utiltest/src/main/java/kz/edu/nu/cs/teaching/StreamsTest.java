package kz.edu.nu.cs.teaching;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
        try {
            Stream<String> l = Files.lines(Paths.get("lambtest.txt"));
            l.forEach(System.out::println);
            l.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
