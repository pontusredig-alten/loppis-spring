package se.iths.loppis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.loppis.entity.AuthGroup;

import java.util.List;

@Repository
public interface AuthGroupRepository extends CrudRepository<AuthGroup, Long> {
    List<AuthGroup> findByUsername(String username);
}
