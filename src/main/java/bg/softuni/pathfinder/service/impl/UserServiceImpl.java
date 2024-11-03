package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.dto.RegisterDTO;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.model.entity.UserRole;
import bg.softuni.pathfinder.model.enums.Role;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.repository.UserRoleRepository;
import bg.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.mapper = mapper;
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

    @Override
    public void registrationUser(RegisterDTO registerDTO) {
        User user = mapper.map(registerDTO, User.class);

        UserRole userRole;

        if (userRepository.count() == 0) {
            userRole = userRoleRepository.findAllById(1);
        } else {
            userRole = userRoleRepository.findAllById(3);
        }

        Set<UserRole> currentUserRole = user.getUserRole();
        currentUserRole.add(userRole);

        System.out.println();
    }
}
