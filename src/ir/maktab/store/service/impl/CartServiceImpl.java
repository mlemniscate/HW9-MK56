package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.domain.Product;
import ir.maktab.store.repository.CartRepository;
import ir.maktab.store.service.CartService;

public class CartServiceImpl extends BaseServiceImpl<Cart, Long, CartRepository> implements CartService {

    private final CartRepository repository;

    public CartServiceImpl(CartRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public void addProductToCart(Product product, Cart cart) {
        if(hasSameProduct(product, cart)){
            
        }else if(cart.getProducts().size() < cart.getProductLimit()) {

        } else {

        }
    }

    private boolean hasSameProduct(Product product, Cart cart) {
        for (Product productKey : cart.getProducts().keySet()) {
            if(productKey.getId().equals(product.getId())) return true;
        }
        return false;
    }

    @Override
    public Cart findByCustomerId(Long customerId) {
        return null;
    }
}
