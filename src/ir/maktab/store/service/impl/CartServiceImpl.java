package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.domain.Product;
import ir.maktab.store.repository.CartRepository;
import ir.maktab.store.service.CartService;

import java.util.Map;
import java.util.Objects;

public class CartServiceImpl extends BaseServiceImpl<Cart, Long, CartRepository> implements CartService {

    private final CartRepository repository;

    public CartServiceImpl(CartRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public void addProductToCart(Product product, Cart cart, int quantity) {
        Map<Product, Integer> products = cart.getProducts();
        Product equalProduct = hasSameProduct(product, cart);
        if(!Objects.isNull(equalProduct)){
            products.put(product, products.get(equalProduct) + quantity);
            repository.updateProduct(cart.getId(),product.getId() , products.get(product));
        }else if(products.size() < cart.getProductLimit()) {
            products.put(product, quantity);
            repository.saveProduct(cart.getId(), quantity, product.getId());
        } else {
            System.out.println("Your cart is full!");
        }
    }

    private Product hasSameProduct(Product product, Cart cart) {
        if (!Objects.isNull(cart.getProducts())) {
            for (Product productKey : cart.getProducts().keySet()) {
                if (productKey.getId().equals(product.getId())) return productKey;
            }
        }
        return null;
    }

    @Override
    public Cart findByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }
}
