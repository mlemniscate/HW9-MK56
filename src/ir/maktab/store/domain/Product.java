package ir.maktab.store.domain;

import ir.maktab.store.base.domain.BaseProduct;

import java.util.List;

public class Product extends BaseProduct<Product> {
    private Integer categoryId;
    private Integer stock;

    public Product(String name, double price, List<ProductAttribute> attributes, Integer categoryId, Integer stock) {
        this(0L, name, price, attributes, categoryId, stock);
    }

    public Product(Long id, String name, double price, List<ProductAttribute> attributes, Integer categoryId, Integer stock) {
        super(id, name, price, attributes);
        this.categoryId = categoryId;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("Product Name: %s%n" +
                "Price: %.2f$%n%s",
                getName(),getPrice(),attributesString()
        );
    }

    private String attributesString() {
        StringBuilder attributesString = new StringBuilder();
        for (ProductAttribute attribute: super.getAttributes()) {
            attributesString.append(attribute.toString()).append("\n");
        }
        return attributesString.toString();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
