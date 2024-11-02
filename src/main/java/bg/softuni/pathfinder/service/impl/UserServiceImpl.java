package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //check is exist user by username
    @Override
    public boolean isExistUser(String username) {

       return userRepository.findByUsername(username).isPresent();
    }

    //check is exist email
    @Override
    public boolean isExistEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
