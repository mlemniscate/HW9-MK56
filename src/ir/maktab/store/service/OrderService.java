package ir.maktab.store.service;

import ir.maktab.store.base.service.BaseService;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.domain.Customer;
import ir.maktab.store.domain.Order;

import java.sql.SQLException;

public interface OrderService extends BaseService<Order, Long> {

    void orderCart(Cart cart, Customer customer) throws SQLException;

}
