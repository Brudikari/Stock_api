package payetonkawa.api.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payetonkawa.api.stock.model.Stock;
import payetonkawa.api.stock.service.StockService;

import java.util.Optional;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    /**
     * Crée un nouveau stock en base de données
     * @param stock l'objet à créer
     * @return le stock enregistré
     */
    @PostMapping("/stock")
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    /**
     * Récupère un stock par son identifiant
     * @param id l'identifiant du stock
     * @return l'objet stock s'il existe, null sinon
     */
    @GetMapping("/stock/{id}")
    public Stock getStock(@PathVariable("id") final Integer id) {
        Optional<Stock> stock = stockService.findStockById(id);
        System.out.println(stock);
        return stock.orElse(null);
    }

    /**
     * Récupère une liste de stock
     * @return une liste de stock
     */
    @GetMapping("/stock")
    public Iterable<Stock> getStock() {
        System.out.println(stockService.getAllStock());
        return stockService.getAllStock();
    }

    /**
     * Met à jour un stock
     * @param id l'identifiant du stock
     * @param stock le stock qu'on veut mettre à jour
     * @return retourne l'objet stock mis à jour
     */
    @PutMapping("/stock/{id}")
    public Stock updateStock(@PathVariable("id") final Integer id, @RequestBody Stock stock) {

        Optional<Stock> s = stockService.findStockById(id);
        if (s.isPresent()) {
            Stock currentStock = s.get();

            Integer stockId = stock.getId();
            if(stockId != null) {
                currentStock.setId(stockId);
            }
            Integer productId = stock.getProductId();
            if(productId != null) {
                currentStock.setProductId(productId);
            }

            int remainingStock = stock.getRemaining();
            currentStock.setRemaining(remainingStock);

            stockService.saveStock(currentStock);
            return currentStock;
        } else {
            return null;
        }
    }

    /**
     * Supprime un stock par son identifiant
     * @param id l'identifiant du stock
     */
    @DeleteMapping("/stock/{id}")
    public void deleteStock(@PathVariable("id") final Integer id) {
        stockService.deleteStockById(id);
    }
}
