package ir.maktab.store.service;

import ir.maktab.store.base.service.BaseProductService;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.domain.Product;

import java.sql.SQLException;

public interface ProductService extends BaseProductService<Product> {

    Product getProduct() throws SQLException;

    Product checkStocks(Cart cart);
}
