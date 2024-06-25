package payetonkawa.api.stock.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payetonkawa.api.stock.model.Stock;
import payetonkawa.api.stock.repository.StockRepository;

import java.util.Optional;

@Data
@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Optional<Stock> findStockById(Integer id) {
        return stockRepository.findById(id);
    }

    public Iterable<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStockById(Integer id) {
        stockRepository.deleteById(id);
    }
}
