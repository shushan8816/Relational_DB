package services;

import models.User;
import test.Create;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserServiceImp implements UserService {
    Scanner s = new Scanner(System.in);
    String currentFileName = Create.currentFileName;

    @Override
    public List<String> getAllUsers() {

        //  return FileService.read("src\\DB\\userDB.txt");
        return FileService.read("src\\DB\\" + this.currentFileName + ".txt");
    }

    @Override
    public List<String> getUsersById(int ID) {
        System.out.println("Enter Id");
        int id = s.nextInt();
        List<String> list = FileService.readFileAsLines("src\\DB\\" + this.currentFileName + ".txt");
        if (list.size() < id) {
            System.out.println("Enter correct Id ");
        }
        for (String user : list) {
            if (Character.getNumericValue(user.charAt(4)) == id) {
                System.out.println(user);
                break;
            }
        }
        return list;
    }

    @Override
    public void addUser() {
        User user = createUser();
        //  FileService.write("src\\DB\\userDB.txt", user.getUserInfo() + "\n");
        FileService.write("src\\DB\\" + this.currentFileName + ".txt", user.getUserInfo() + "\n");
    }

    User createUser() {
        User user = new User();
        System.out.println("Enter ID");
        int id = s.nextInt();
        user.setID(id);
        s.nextLine();
        System.out.println("Enter name");
        String name = s.nextLine();
        user.setName(name);
        System.out.println("Enter email");
        String email = s.nextLine();
        user.setEmail(email);
        System.out.println("Enter phone number");
        String phone = s.nextLine();
        user.setPhone(phone);
        System.out.println("Enter country");
        String country = s.nextLine();
        user.setCountry(country);
        System.out.println("Enter age");
        int age = s.nextInt();
        user.setAge(age);
        return user;

    }

    @Override
    public void updateUser(User user) {
        System.out.println("Please enter the contents of a line you would like to edit: ");
        String lineToUpdate = s.nextLine();
        System.out.println("Please enter the the replacement text: ");
        String replacementText = s.nextLine();

    }

    @Override
    public List<String> deleteUser(int ID) {
        System.out.println("Enter user Id");
        int Id = s.nextInt();
        List<String> list = null;
        try {
            //  FileService.removeLine("src\\DB\\userDB.txt", "Id");
            FileService.removeLine("src\\DB\\" + this.currentFileName + ".txt", "Id");
            for (String user : list) {
                if (Character.getNumericValue(user.charAt(4)) == Id) {
                    System.out.println(user);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println();
            e.printStackTrace();
        }
        return list;
    }
}
