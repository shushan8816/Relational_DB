package services;

import models.User;
import testCRUD.Create;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    static String fileName = Create.currentFileName;

    @Override
    public void addUser() {
        User user = createUser();
        FileService.write(fileName, user.getUserInfo() + "\n");
    }

    private User createUser() {
        Scanner s = new Scanner(System.in);
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
    public List<String> getAllUsers() {
        return FileService.read(fileName);
    }

    @Override
    public String getUsersById() {
        int id = insertId();
        String user = findUser(id);
        if (user != null) return user;
        return "No such User found";
    }

    private int insertId() {
        System.out.println("Enter Id");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private String findUser(int id) {
        List<String> list = FileService.readFileAsLines(fileName);
        for (String user : list) {
            String number = user.split(" ")[2];
            number = number.substring(0, number.length() - 1);
            int nn = Integer.parseInt(number);
            if (nn == id) {
                return user;
            }
        }
        return null;
    }
    @Override
    public void removeUserByID() {
        int id = insertId();
        List<String> list = FileService.readFileAsLines(fileName);
        list.remove(findUser(id));
        FileService.removeAndWrite(fileName, list);
    }
    @Override
    public void updateUser() {
        String user = getUsersById();
        String[] userArray = user.split(",");
        int ID = Integer.parseInt(userArray[0].split(":")[1].trim());
        String name = userArray[1].split(":")[1].trim();
        String email = userArray[2].split(":")[1].trim();
        String phone = userArray[3].split(":")[1].trim();
        String country = userArray[4].split(":")[1].trim();
        int age = Integer.parseInt(userArray[5].split(":")[1].replace("}", "").trim());

        User currentUser = new User(ID, name, email, phone, country, age);
        System.out.println(currentUser);

        Scanner input = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("Update user fields");
            System.out.println("1. Enter ID");
            System.out.println("2. Enter Name");
            System.out.println("3. Enter Email");
            System.out.println("4. Enter Phone number");
            System.out.println("5. Enter Country");
            System.out.println("6. Enter Age");
            System.out.println("7. Enter Exit");

            int inputData = input.nextInt();
            Scanner s = new Scanner(System.in);
            switch (inputData) {
                case 1:
                    System.out.println("Enter new ID");
                    int newID = s.nextInt();
                    currentUser.setID(newID);
                    break;
                case 2:
                    System.out.println("Enter new name");
                    String newName = s.nextLine();
                    currentUser.setName(newName);
                    break;
                case 3:
                    System.out.println("Enter new email");
                    String newEmail = s.nextLine();
                    currentUser.setEmail(email);
                    break;
                case 4:
                    System.out.println("Enter new phone number");
                    String newPhone = s.nextLine();
                    currentUser.setPhone(phone);
                    break;
                case 5:
                    System.out.println("Enter new country");
                    String newCountry = s.nextLine();
                    currentUser.setCountry(country);
                    break;
                case 6:
                    System.out.println("Enter new Age");
                    int newAge = s.nextInt();
                    currentUser.setAge(age);
                    break;
                case 7:
                    updateFile(user, currentUser.getUserInfo());
                    isActive = false;
                    System.out.println("=== Exit ===");
                    break;
                default:
                    System.out.println("Please, enter correct command!!!");
            }
        }
    }

    private void updateFile(String user, String newUser) {
        List<String> list = FileService.readFileAsLines(fileName);
        Collections.replaceAll(list, user, newUser);
        FileService.removeAndWrite(fileName, list);

    }
}
