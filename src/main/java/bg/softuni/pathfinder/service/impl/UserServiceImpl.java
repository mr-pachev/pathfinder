package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean isExistUser(String username) {
        return false;
    }
}
