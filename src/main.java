

import test.Create;
import test.Delete;
import test.Insert;
import test.Select;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class main {
    public static String currentFileName;
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("==== Welcome to DBMS ==== ");

        boolean isActive = true;
        while (isActive) {
            System.out.println("Enter command:");
            String inputData = input.nextLine();

            switch (inputData) {
                case "Create":
                    Create.create();
                    break;
                case "Insert":
                    Insert.insert();
                    break;
                case "Select":
                    Select.selectAll();
                    break;
                case "SelectOne":
                    Select.selectOneById();
                    break;
                case "Update":
                    break;
                case "Delete":
                    Delete.deleteUser(2);
                    break;
                case "":
                    isActive = false;
                    break;
                default:
                    System.out.println("Please, enter correct command!!!");
                    System.out.println("=== Exit ===");
            }
        }
    }
}
