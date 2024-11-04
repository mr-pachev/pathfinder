package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.dto.RegisterDTO;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.model.entity.UserRole;
import bg.softuni.pathfinder.model.enums.Role;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.repository.UserRoleRepository;
import bg.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
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

    //add new user
    @Override
    public void registrationUser(RegisterDTO registerDTO) {
        User user = mapper.map(registerDTO, User.class);

        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        UserRole userRole = userRoleRepository.findByName(Role.USER);

        Set<UserRole> currentUserRole = new HashSet<>();
        currentUserRole.add(userRole);

        //adding an administrator role to the first user
        if (userRepository.count() == 0) {
            currentUserRole.add(userRoleRepository.findByName(Role.ADMIN));
        }

        user.setUserRole(currentUserRole);

        userRepository.save(user);
    }
}
