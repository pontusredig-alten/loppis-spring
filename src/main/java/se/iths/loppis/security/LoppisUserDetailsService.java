package se.iths.loppis.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.loppis.entity.AuthGroup;
import se.iths.loppis.entity.User;
import se.iths.loppis.repository.AuthGroupRepository;
import se.iths.loppis.repository.UserRepository;

import java.util.List;

@Service
public class LoppisUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    private AuthGroupRepository authGroupRepository;

    public LoppisUserDetailsService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        super();
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException("Can't find username: " + username);
        }
        List<AuthGroup> authGroups = authGroupRepository.findByUsername(username);
        return new LoppisUserPrincipal(user, authGroups);
    }

}
