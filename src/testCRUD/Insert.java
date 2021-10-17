package testCRUD;

import services.UserServiceImpl;

public class Insert {

    public static void insert() {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.addUser();
    }
}
