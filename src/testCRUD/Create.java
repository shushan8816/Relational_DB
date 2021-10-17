package testCRUD;

import services.FileService;
import services.MenuService;

import java.io.IOException;
import java.util.Scanner;

public class Create {
    static Scanner inputCommand = new Scanner(System.in);
    public static String currentFileName;

    public static void getMainMenu() {

        boolean isActive = true;
        while (isActive) {
            System.out.println("1. Create New File");
            System.out.println("2. Select File");
            System.out.println("3. Exit");
            System.out.println("Enter Command:");
            int command = inputCommand.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Enter file name:");
                    Scanner scannerCreate = new Scanner(System.in);
                    String fileName = scannerCreate.nextLine();
                    currentFileName = fileName;
                    try {
                        if (FileService.createNewFile(fileName)) {
                            System.out.println("File created: " + fileName + ".txt");
                            isActive = false;
                            MenuService.getActionMenu();
                        } else System.out.println("File already exists.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2: {
                    Scanner scannerCheck = new Scanner(System.in);
                    System.out.println("Enter file name:");
                    String fileName2 = scannerCheck.nextLine();
                    currentFileName = fileName2;

                    if (FileService.isFileExist(fileName2)) {
                        isActive = false;
                        MenuService.getActionMenu();
                    } else {
                        System.out.println("No such file exist");
                        isActive = false;
                        getMainMenu();
                    }
                    break;
                }
                case 3:
                    isActive = false;
                    System.out.println("=== Exit ===");
                    break;
                default:
                    System.out.println("Please, enter correct command!!!");
            }
        }
    }
}
   /* static Scanner input = new Scanner(System.in);
   public static String currentFileName;

    public static void create() {
        System.out.println("Enter file name:");
        String fileName = input.nextLine();
        currentFileName = fileName;
        try {
            FileService.createFile("src\\DB\\", fileName + ".txt");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Enter right command");
        }*/

   /* static Scanner inputCommand = new Scanner(System.in);
    static String currentFileName;
   public static void getMainMenu() {

       boolean isActive = true;
       while (isActive) {
           System.out.println("1. Create New File");
           System.out.println("2. Select File");
           System.out.println("3. Exit");
           System.out.println("Enter Command:");
           int command = inputCommand.nextInt();

           switch (command) {
               case 1:
                   System.out.println("Enter file name:");
                   Scanner scannerCreate = new Scanner(System.in);
                   String fileName = scannerCreate.nextLine();
                   currentFileName = fileName;
                   try {
                       if (FileService.createNewFile(fileName)) {
                           System.out.println("File created: " + fileName + ".txt");
                           isActive = false;
                           getActionMenu();
                       } else System.out.println("File already exists.");
                   } catch (IOException e) {
                       e.printStackTrace();
                   }

                   break;
               case 2: {
                   Scanner scannerCheck = new Scanner(System.in);
                   System.out.println("Enter file name:");
                   String fileName2 = scannerCheck.nextLine();
                   currentFileName = fileName2;

                   //  Insert.insert();
                   if (FileService.isFileExist(fileName2)) {
                       isActive = false;
                       getActionMenu();
                   } else {
                       System.out.println("No such file exist");
                       isActive = false;
                       getMainMenu();
                   }
                   break;
               }
               case 3:
                   isActive = false;
                   System.out.println("=== Exit ===");
                   break;
               default:
                   System.out.println("Please, enter correct command!!!");
           }
       }
   }

    private static void getActionMenu() {
    }
}*/
