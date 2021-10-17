package test;

import services.UserServiceImp;

public class Insert {
    public static void insert() {

        UserServiceImp userServiceImp = new UserServiceImp();
        userServiceImp.addUser();
    }
}
