package testCRUD;

import services.UserServiceImpl;

public class Update {
    public static void update() {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.updateUser();

    }
}
