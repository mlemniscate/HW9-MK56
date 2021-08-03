package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.domain.Product;
import ir.maktab.store.repository.CartRepository;
import ir.maktab.store.service.CartService;

import java.util.Objects;

public class CartServiceImpl extends BaseServiceImpl<Cart, Long, CartRepository> implements CartService {

    private final CartRepository repository;

    public CartServiceImpl(CartRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public void addProductToCart(Product product, Cart cart, int quantity) {
        if(hasSameProduct(product, cart)){
            cart.getProducts().put(product, cart.getProducts().get(product) + quantity);
            repository.updateProduct(cart.getId(), cart.getProducts().get(product));
        }else if(cart.getProducts().size() < cart.getProductLimit()) {
            cart.getProducts().put(product, quantity);
            repository.saveProduct(cart.getId(), quantity);
        } else {
            System.out.println("Your cart is full!");
        }
        System.out.println(cart.getProducts().get(product));
    }

    private boolean hasSameProduct(Product product, Cart cart) {
        if (!Objects.isNull(cart.getProducts())) {
            for (Product productKey : cart.getProducts().keySet()) {
                if (productKey.getId().equals(product.getId())) return true;
            }
        }
        return false;
    }

    @Override
    public Cart findByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }
}
