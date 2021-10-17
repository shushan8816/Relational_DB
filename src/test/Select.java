package test;

import services.UserServiceImp;


public class Select {
    public static void selectAll() {
        UserServiceImp usi1 = new UserServiceImp();
        usi1.getAllUsers();
    }

    public static void selectOneById() {
        UserServiceImp usi2 = new UserServiceImp();
        usi2.getUsersById(2);
    }
}


