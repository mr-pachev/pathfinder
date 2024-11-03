package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.RegisterDTO;

public interface UserService {
    //check is exist user by username
    boolean isExistUser(String username);

    //check is exist email
    boolean isExistEmail(String email);

    //add new user
    void registrationUser(RegisterDTO registerDTO);
}
