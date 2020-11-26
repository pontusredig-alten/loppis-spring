package se.iths.loppis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.loppis.entity.AuthGroup;
import se.iths.loppis.entity.User;
import se.iths.loppis.repository.AuthGroupRepository;
import se.iths.loppis.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    AuthGroupRepository authGroupRepository;

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Constructor injection
    public UserService(UserRepository userRepository, TestScopes testScopes) {
        this.userRepository = userRepository;
    }

    // Setter injection
//    @Autowired
//    void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    public User createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        authGroupRepository.save(new AuthGroup(user.getUsername(), "USER"));
//        authGroupRepository.save(new AuthGroup(user.getUsername(), "ADMIN"));
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        userRepository.deleteById(foundUser.get().getId());
    }


    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        Optional<User> foundUser = Optional.ofNullable(userRepository.findByUsername(username));

        return foundUser.get();
    }

    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String owner = authentication.getName();
        Optional<User> userOptional = Optional.ofNullable(getUserByUsername(owner));

        return userOptional.get();
    }


}
