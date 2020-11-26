package se.iths.loppis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.loppis.entity.Item;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.user.id = :id")
    Iterable<Item> findItemsByUserId(Long id);

    @Query("SELECT i FROM Item i WHERE i.user.username = :#{ principal?.username }")
    List<Item> findAllByUser();


}
