package services;

import models.User;

import java.util.List;

public interface UserService {

    List<String> getAllUsers();

    List<String> getUsersById(int ID) ;

    void addUser();

    void updateUser(User user);

    List<String> deleteUser(int ID);

}
