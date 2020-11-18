package se.iths.loppis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.loppis.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.user.id = :id")
    Iterable<Item> findItemsByUserId(Long id);

}
