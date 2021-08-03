package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.domain.Product;
import ir.maktab.store.front.input.InputInt;
import ir.maktab.store.repository.CartRepository;
import ir.maktab.store.service.CartService;
import ir.maktab.store.service.dto.CartProductChangeDTO;

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
        if (!Objects.isNull(equalProduct)) {
            products.put(product, products.get(equalProduct) + quantity);
            repository.updateProduct(new CartProductChangeDTO(cart.getId(), product.getId(), products.get(product)));
        } else if (products.size() < cart.getProductLimit()) {
            products.put(product, quantity);
            repository.saveProduct(new CartProductChangeDTO(cart.getId(), product.getId(), quantity));
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

    @Override
    public void showCartProducts(Cart cart) {
        double totalPrice = 0;
        int productNumber = 0;
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            System.out.println("\n\n");
            System.out.println("#" + ++productNumber);
            System.out.print(entry.getKey().toString());
            System.out.println("Quantity: " + entry.getValue() + "\n");
            totalPrice += entry.getKey().getPrice();
        }
        System.out.printf("Your cart total price is: %.2f$%n%n", totalPrice);
    }

    @Override
    public void deleteItem(Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        int deletedItem = enterProductNumber(products.size()) - 1;
        Product product = products.keySet().toArray(new Product[0])[deletedItem];
        repository.deleteProduct(new CartProductChangeDTO(cart.getId(), product.getId(), products.get(product)));
        products.remove(product);
        showCartProducts(cart);
    }

    private static int enterProductNumber(int size) {
        return new InputInt("Enter your product number: ",
                "This product not available in the product list.\nInput a valid number.", size, 1, null).getIntInput();
    }
}
