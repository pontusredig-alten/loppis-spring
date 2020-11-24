package se.iths.loppis.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.loppis.entity.User;
import se.iths.loppis.repository.UserRepository;

@Service
public class LoppisUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public LoppisUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException("Can't find username: " + username);
        }
        return new LoppisUserPrincipal(user);
    }
}
