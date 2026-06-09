package lk.rasheeda.ejb.stock;

import jakarta.ejb.Stateless;

import java.util.HashMap;
import java.util.Map;

@Stateless
public class StockBean implements StockService {

    private Map<String,Integer> stock = new HashMap<String,Integer>();

    public StockBean() {
        stock.put("Apple",25);
        stock.put("Orange",7);
        stock.put("Avacado",7);
        stock.put("Peach",7);
        stock.put("Mango",7);
    }

    @Override
    public int getStock(String product) {
        return stock.getOrDefault(product,0);
    }
}
