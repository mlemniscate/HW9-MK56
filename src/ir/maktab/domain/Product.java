package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;

public class Product extends BaseEntity<Long> {
    private String name;
    private Integer categoryId;
    private double price;
    private int stock;

    public Product(String name, Integer categoryId, double price, int stock) {
        this(0L, name, categoryId, price, stock);
    }

    public Product(Long id, String name, Integer categoryId, double price, int stock) {
        super(id);
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format (
                "Product name: %s%n" +
                "Price: %.2f$%n",
                name, price
        );
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
