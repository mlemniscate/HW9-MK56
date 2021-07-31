package ir.maktab.service.impl;
import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.domain.Cart;
import ir.maktab.repository.CartRepository;

public class CartServiceImpl extends BaseServiceImpl<Cart, Long, CartRepository> {

    public CartServiceImpl(CartRepository repository) {
        super(repository);
    }
}
