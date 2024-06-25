package payetonkawa.api.stock.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import payetonkawa.api.stock.model.Stock;

import java.util.Optional;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer> {

    @Query("SELECT s FROM Stock s WHERE s.id =: id")
    Optional<Stock> findById(Integer id);
}
