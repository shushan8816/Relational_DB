package testCRUD;


import services.UserServiceImpl;

public class Delete {
    public static void delete(){
        UserServiceImpl userServiceImpl =new UserServiceImpl();
        userServiceImpl.removeUserByID();
    }
}
