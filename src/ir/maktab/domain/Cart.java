package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;

import java.sql.Date;
import java.util.Map;

public class Cart extends BaseEntity<Long> {

    private Long customerId;
    private Date createdDate;
    private Date lastUpdatedDate;
    private Map<Product, Integer> products;

    public Cart(Long customerId, Date createdDate, Date lastUpdatedDate, Map<Product, Integer> products) {
        this(0L, customerId, createdDate, lastUpdatedDate, products);
    }

    public Cart(Long aLong, Long customerId, Date createdDate, Date lastUpdatedDate, Map<Product, Integer> products) {
        super(aLong);
        this.customerId = customerId;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
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
