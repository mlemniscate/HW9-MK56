package ir.maktab.store.service.impl;

import ir.maktab.store.ApplicationContext;
import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.*;
import ir.maktab.store.repository.OrderRepository;
import ir.maktab.store.service.OrderService;
import ir.maktab.store.service.dto.CartProductChangeDTO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OrderServiceImpl extends BaseServiceImpl<Order, Long, OrderRepository> implements OrderService{

    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }

    @Override
    public void orderCart(Cart cart, Customer customer) throws SQLException {
        payOff(cart, customer);
    }

    private void payOff(Cart cart, Customer customer) throws SQLException {
        double paymentPrice = ApplicationContext.cartService.calculateCartTotalPrice(cart);
        Product lessStockProduct = ApplicationContext.productService.checkStocks(cart);
        if (Objects.isNull(lessStockProduct)) {
            if (customer.getBalance() > paymentPrice) {
                Shipper shipper = ApplicationContext.shipperService.chooseShipper();
                paymentPrice += shipper.getPrice();
                if(customer.getBalance() > paymentPrice) {
                    doOrderUpdates(cart, customer, paymentPrice, shipper);
                    System.out.println("Your orders ordered successfully.");
                } else {
                    System.out.println("Your balance not enough for this payment.\nPlease deposit your balance and come back again.");
                }
            } else {
                System.out.println("Your balance not enough for this payment.\nPlease deposit your balance and come back again.");
            }
        } else {
            System.out.printf("We have not enough stock from bellow product. " +
                            "Please delete and order enough amount of that.%n" +
                            "%s%n" +
                            "Stock: %d%n%n",
                    lessStockProduct, lessStockProduct.getStock());
        }
    }

    private void doOrderUpdates(Cart cart, Customer customer, double paymentPrice, Shipper shipper) throws SQLException {
        updateBalance(paymentPrice, customer);
        Order order = new Order(
                customer.getId(),
                new Date(System.currentTimeMillis()),
                shipper);
        save(order);
        addOrderDetails(cart, order);
    }

    private void updateBalance(double paymentPrice, Customer customer) {
        customer.setBalance(customer.getBalance() - paymentPrice);
        ApplicationContext.customerService.update(customer);
    }

    private void addOrderDetails(Cart cart, Order order) throws SQLException {
        addPurchasedProducts(cart, order);
    }

    private void addPurchasedProducts(Cart cart, Order order) {
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product key = entry.getKey();
            PurchasedProduct purchasedProduct = new PurchasedProduct(
                    key.getName(),
                    key.getPrice(),
                    key.getAttributes(),
                    order.getId(),
                    entry.getValue()
            );
            ApplicationContext.purchasedProductService.save(purchasedProduct);
            addPurchasedProductsAttributes(purchasedProduct.getAttributes());
            ApplicationContext.cartService.deleteCartProduct(new CartProductChangeDTO(
                    cart.getId(),entry.getKey().getId(), entry.getValue()
            ));
        }
    }

    private void addPurchasedProductsAttributes(List<ProductAttribute> attributes) {
        for (ProductAttribute attribute : attributes) {
            ApplicationContext.purchasedProductService.saveAttribute(attribute);
        }
    }
}
