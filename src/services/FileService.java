package services;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {
    private static final String filePath = "src\\DB\\";

    public static boolean createNewFile(String name) throws IOException {

        File db = new File(filePath + File.separator + name + ".txt");
        return db.createNewFile();
        
    }

    public static void createFile(String name) {
        try {
            File db = new File(filePath + File.separator + name + ".txt");

            if (db.createNewFile()) {
                System.out.println("File created: " + db.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static boolean isFileExist(String fileName) {
        File db = new File(filePath + File.separator + fileName + ".txt");
        return db.exists();
    }

    public static void write(String fileName, String content) {
        try {
            Files.write(Paths.get(filePath + fileName + ".txt"), content.getBytes(), StandardOpenOption.APPEND);
            System.out.println("User successfully added!");
        } catch (IOException e) {
            System.out.println("Enter correct file name");
        }
    }

    public static List<String> read(String fileName) {
        List<String> fileData = null;
        try {
            fileData = Files.readAllLines(Paths.get(filePath + fileName + ".txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception while reading data from file");
        }
        return fileData;
    }

    public static List<String> readFileAsLines(String fileName) {
        List<String> lines = null;
        try {
            lines = Files.lines(Paths.get(filePath + fileName + ".txt")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void removeAndWrite(String fileName, List<String> content) {
        try {
            Files.write(Paths.get("src\\DB\\" + fileName + ".txt"), content, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

