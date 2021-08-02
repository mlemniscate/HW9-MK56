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
    public void addProductToCart(Product product) {

    }
}
