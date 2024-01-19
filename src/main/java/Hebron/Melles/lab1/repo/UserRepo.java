package Hebron.Melles.lab1.repo;

import Hebron.Melles.lab1.domain.User;
import Hebron.Melles.lab1.domain.UserDto;

import java.util.List;

public interface UserRepo {
    List<UserDto> getAllUsers();
    UserDto getUserById(int id);
    String createNewUser();
    User getUserAndPost(int id);

}
