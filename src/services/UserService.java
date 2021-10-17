package services;

import java.util.List;

public interface UserService {

    void addUser();

    List<String> getAllUsers();

    String getUsersById();

    void removeUserByID();

    void updateUser();
}
