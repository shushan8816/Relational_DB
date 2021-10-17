package services;

import testCRUD.*;

import java.util.Scanner;

public class MenuService {

   public static void getActionMenu() {
       Create.getMainMenu();
        Scanner input = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("1. Insert");
            System.out.println("2. Select all");
            System.out.println("3. Select by ID");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");
            System.out.println("Enter command:");
            int inputData = input.nextInt();

            switch (inputData) {

                case 1:
                    Insert.insert();
                    break;
                case 2:
                    Select.selectAll();
                    break;
                case 3:
                    Select.selectById();
                    break;
                case 4:
                    Update.update();
                    break;
                case 5:
                    Delete.delete();
                    break;
                case 6:
                    isActive = false;
                    System.out.println("=== Exit ===");
                    break;
                default:
                    System.out.println("Please, enter correct command!!!");
            }
        }
    }
}
