package project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesWalkDirectoriesEx {

    public static void main(String[] args) throws IOException {

        var dirName = "C:\\Users\\lespi\\desktop";

        try (Stream<Path> paths = Files.walk(Paths.get(dirName))) {
            paths.filter(Files::isDirectory).forEach(System.out::println);
        }
        try (Stream<Path> paths = Files.walk(Paths.get(dirName), 2)) {
        	paths.filter(Files::isRegularFile).forEach(System.out::println);
        }
    }
}