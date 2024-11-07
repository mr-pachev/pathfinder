package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserHelperService {
    private static final String ROLE_PREFIX = "ROLE_";
    private final UserRepository userRepository;


    public UserHelperService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUser() {
        return userRepository.findByUsername(getUserDetails().getUsername())
                .orElse(null);
    }

    public boolean hasRole(String role) {
        return getAuthentication().getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(ROLE_PREFIX + role));
    }

    public UserDetails getUserDetails() {
        return (UserDetails) getAuthentication().getPrincipal();
    }

    public boolean isAuthenticated() {
        //Spring security sets default user with Role ANONYMOUS when no user is authenticated.
        return !hasRole("ANONYMOUS");
    }

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
