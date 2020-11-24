package se.iths.loppis.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.loppis.entity.User;
import se.iths.loppis.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    // Constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Setter injection
//    @Autowired
//    void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    public User createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
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

}
