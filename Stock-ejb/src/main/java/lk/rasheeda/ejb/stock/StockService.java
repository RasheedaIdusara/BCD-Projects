package lk.rasheeda.ejb.stock;

import jakarta.ejb.Remote;

@Remote
public interface StockService {
    int getStock(String product);
}
