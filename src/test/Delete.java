package test;

import services.UserServiceImp;

public class Delete {
    public static void deleteUser(int ID) {
        UserServiceImp deleted = new UserServiceImp();
        deleted.deleteUser(2);
    }
}
