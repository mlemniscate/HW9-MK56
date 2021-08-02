package ir.maktab.store.service;

import ir.maktab.store.base.service.BaseService;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.domain.Product;

public interface CartService extends BaseService<Cart, Long> {
    void addProductToCart(Product product);
}
