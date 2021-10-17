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

    public static void createFile(String filePath, String name) {
        try {
            File db = new File(filePath + File.separator + name);
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

    public static void write(String filePath, String content) {
        try {
            Files.write(Paths.get(filePath), content.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Enter correct file name");
        }
    }

    public static List<String> read(String filePath) {
        List<String> fileData = null;
        try {
            fileData = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception while reading data from file");
        }
        return fileData;
    }

    public static List<String> readFileAsLines(String filePath) {
        List<String> lines = null;
        try {
            lines = Files.lines(Paths.get(filePath)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void removeLine(String filePath, String lineContent) throws IOException {
        List<String> out = Files.lines(Paths.get(filePath))
                .filter(line -> !line.contains(lineContent.replaceAll(",", "")))
                .collect(Collectors.toList());
        Files.write(Paths.get(filePath), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void replaceLines(String filePath, String oldLineContent, String newLineContent) {
        String oldLine = oldLineContent.replaceAll(",", "");
        String newLine = newLineContent.replaceAll(",", "");

        List<String> fileContent = null;
        try {
            fileContent = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            for (String line : fileContent) {
                System.out.println(line);
                System.out.println(oldLine);
                if (line.trim().equals(oldLine.trim())) {
                    System.out.println(oldLine);
                    fileContent.add(newLine);
                    break;
                }
            }
            Files.write(Paths.get(filePath), fileContent, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//        String response = "{ID: 4099827e-93f1-4d42-a563-01b9af5d31b3,name: Aram,email: test@test.ru,phone: 123456,country: Armenia,age: 20}";
//
//        String ID = response.split(",")[0].split(":")[1].trim();
//        String name = response.split(",")[1].split(":")[1].trim();
//        String email = response.split(",")[2].split(":")[1].trim();
//        String country = response.split(",")[3].split(":")[1].trim();
//        String phone = response.split(",")[4].split(":")[1].trim();
//        int age = Integer.parseInt(response.split(",")[5].split(":")[1].replace("}", "").trim());
//
//        System.out.println("ID = " + ID);
//        System.out.println("name = " + name);
//        System.out.println("email = " + email);
//        System.out.println("country = " + country);
//        System.out.println("phone = " + phone);
//        System.out.println("age = " + age);
