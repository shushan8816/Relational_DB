package test;

import services.UserServiceImpl;


public class Select {
    public static void selectAll() {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        System.out.println(userServiceImpl.getAllUsers());
    }
    public static void selectById() {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        System.out.println(userServiceImpl.getUsersById());
    }
}


