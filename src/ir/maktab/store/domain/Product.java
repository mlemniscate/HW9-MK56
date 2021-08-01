package ir.maktab.store.domain;

import ir.maktab.store.base.domain.BaseEntity;

import java.util.List;

public class Product extends BaseEntity<Long> {
    private String name;
    private Integer categoryId;
    private double price;
    private int stock;
    private List<ProductAttribute> attributes;

    public Product(String name, Integer categoryId, double price, int stock,  List<ProductAttribute> attributes) {
        this(0L, name, categoryId, price, stock, attributes);
    }

    public Product(Long id, String name, Integer categoryId, double price, int stock, List<ProductAttribute> attributes) {
        super(id);
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.stock = stock;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return String.format (
                "Product name: %s%n" +
                "Price: %.2f$%n",
                name, price
        );
    }

    public List<ProductAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ProductAttribute> attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
