package ir.maktab.store.domain;

import ir.maktab.store.base.domain.BaseProduct;

import java.util.List;

public class ProductPurchased extends BaseProduct<ProductPurchased> {
    private Integer orderId;
    private Integer quantity;

    public ProductPurchased(String name, double price, List<ProductAttribute> attributes, Integer orderId, Integer quantity) {
        this(0L, name, price, attributes, orderId, quantity);
    }

    public ProductPurchased(Long id, String name, double price, List<ProductAttribute> attributes, Integer orderId, Integer quantity) {
        super(id, name, price, attributes);
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
