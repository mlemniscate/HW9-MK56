package ir.maktab.store.domain;

import ir.maktab.store.base.domain.BaseProduct;

import java.util.List;

public class PurchasedProduct extends BaseProduct<PurchasedProduct> {
    private Long orderId;
    private Integer quantity;

    public PurchasedProduct(String name, double price, List<ProductAttribute> attributes, Long orderId, Integer quantity) {
        this(0L, name, price, attributes, orderId, quantity);
    }

    public PurchasedProduct(Long id, String name, double price, List<ProductAttribute> attributes, Long orderId, Integer quantity) {
        super(id, name, price, attributes);
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
