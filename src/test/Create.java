package test;

import services.FileService;

import java.util.Scanner;

public class Create {
    static Scanner input = new Scanner(System.in);
   public static String currentFileName;

    public static void create() {
        System.out.println("Enter file name:");
        String fileName = input.nextLine();
        currentFileName = fileName;
        try {
            FileService.createFile("src\\DB\\", fileName + ".txt");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Enter right command");
        }
    }
}
