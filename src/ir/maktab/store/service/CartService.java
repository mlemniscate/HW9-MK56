package ir.maktab.store.service;

import ir.maktab.store.base.service.BaseService;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.domain.Product;
import ir.maktab.store.service.dto.CartProductChangeDTO;

public interface CartService extends BaseService<Cart, Long> {

    void addProductToCart(Product product, Cart cart, int quantity);

    Cart findByCustomerId(Long customerId);

    void showCartProducts(Cart cart);

    void deleteItem(Cart cart);

    double calculateCartTotalPrice(Cart cart);

    void deleteCartProduct(CartProductChangeDTO cartProductChangeDTO);
}
