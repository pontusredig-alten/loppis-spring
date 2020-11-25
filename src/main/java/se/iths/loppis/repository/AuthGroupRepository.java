package se.iths.loppis.repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.loppis.entity.AuthGroup;

import java.util.List;

public interface AuthGroupRepository extends CrudRepository<AuthGroup, Long> {
    List<AuthGroup> findByUsername(String username);
}
