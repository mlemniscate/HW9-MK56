package ir.maktab.store.domain;

import ir.maktab.store.base.domain.BaseEntity;

import java.sql.Date;

public class Order extends BaseEntity<Long> {
    private Long customerId;
    private Date orderDate;
    private Date shippingDate;
    private Date deliveryDate;
    private Shipper shipper;

    public Order(Long customerId, Date orderDate, Shipper shipper) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.shipper = shipper;
    }

    public Order(Long customerId, Date orderDate, Date shippingDate, Date deliveryDate, Shipper shipper) {
        this(0L, customerId, orderDate, shippingDate, deliveryDate, shipper);
    }

    public Order(Long aLong, Long customerId, Date orderDate, Date shippingDate, Date deliveryDate, Shipper shipper) {
        super(aLong);
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.shippingDate = shippingDate;
        this.deliveryDate = deliveryDate;
        this.shipper = shipper;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }
}
