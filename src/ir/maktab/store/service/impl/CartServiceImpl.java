package ir.maktab.store.service.impl;
import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.repository.CartRepository;

public class CartServiceImpl extends BaseServiceImpl<Cart, Long, CartRepository> {

    public CartServiceImpl(CartRepository repository) {
        super(repository);
    }
}
