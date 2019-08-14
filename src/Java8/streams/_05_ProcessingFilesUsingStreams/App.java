package Java8.streams._05_ProcessingFilesUsingStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws IOException {
        List<String> imlStrings = Files.lines(Paths.get(".gitignore"))
                .filter(line -> line.contains("iml"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(imlStrings);
    }
}
