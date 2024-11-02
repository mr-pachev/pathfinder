package bg.softuni.pathfinder.service;

public interface UserService {
    //check is exist user by username
    boolean isExistUser(String username);

    //check is exist email
    boolean isExistEmail(String email);
}
