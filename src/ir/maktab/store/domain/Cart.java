package ir.maktab.store.domain;

import ir.maktab.store.base.domain.BaseEntity;

import java.sql.Date;
import java.util.Map;

public class Cart extends BaseEntity<Long> {

    private Long customerId;
    private Date createdDate;
    private Date lastUpdatedDate;
    private Integer productLimit;
    private Map<Product, Integer> products;

    public Cart(Long customerId, Date createdDate, Date lastUpdatedDate) {
        this(customerId, createdDate, lastUpdatedDate, 0);
    }

    public Cart(Long customerId, Date createdDate, Date lastUpdatedDate, Integer productLimit) {
        this(customerId, createdDate, lastUpdatedDate, null, productLimit);
    }

    public Cart(Long customerId, Date createdDate, Date lastUpdatedDate, Map<Product, Integer> products, Integer productLimit) {
        this(0L, customerId, createdDate, lastUpdatedDate, products, productLimit);
    }

    public Cart(Long id, Long customerId, Date createdDate, Date lastUpdatedDate, Map<Product, Integer> products, Integer productLimit) {
        super(id);
        this.customerId = customerId;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.products = products;
        this.productLimit = productLimit;
    }

    public Integer getProductLimit() {
        return productLimit;
    }

    public void setProductLimit(Integer productLimit) {
        this.productLimit = productLimit;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
