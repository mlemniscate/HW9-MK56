package ir.maktab.store.base.domain;

import ir.maktab.store.domain.ProductAttribute;
import java.util.List;

public class BaseProduct<E extends BaseProduct<E>> extends BaseEntity<Long> {
    private String name;
    private double price;
    private List<ProductAttribute> attributes;

    public BaseProduct(String name, double price, List<ProductAttribute> attributes) {
        this(0L, name, price, attributes);
    }

    public BaseProduct(Long id, String name, double price, List<ProductAttribute> attributes) {
        super(id);
        this.name = name;
        this.price = price;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProductAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ProductAttribute> attributes) {
        this.attributes = attributes;
    }
}
