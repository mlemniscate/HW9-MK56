package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;

public class Shipper extends BaseEntity<Integer> {
    private String name;
    private String phone;
    private double price;
    private int deliveryDay;

    public Shipper(String name, String phone, double price, int deliveryDay) {
        this(0, name, phone, price, deliveryDay);
    }

    public Shipper(Integer integer, String name, String phone, double price, int deliveryDay) {
        super(integer);
        this.name = name;
        this.phone = phone;
        this.price = price;
        this.deliveryDay = deliveryDay;
    }

    @Override
    public String toString() {
        return String.format("Shipper Name: %s%n" +
                "Phone Number: %s%n" +
                "Price: %.2f%n" +
                "Delivery Day: %d%n",
                name, phone, price, deliveryDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDeliveryDay() {
        return deliveryDay;
    }

    public void setDeliveryDay(int deliveryDay) {
        this.deliveryDay = deliveryDay;
    }
}
