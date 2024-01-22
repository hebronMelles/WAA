package Hebron.Melles.lab1.service;

import Hebron.Melles.lab1.domain.User;
import Hebron.Melles.lab1.domain.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(int id);
    String createNewUser();
    public User getUserAndPost(int id);
    UserDto deleteUserById(int id);

    User getUsersByNumberOfPosts(int n);
}
