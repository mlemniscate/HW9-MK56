package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.domain.Order;
import ir.maktab.repository.OrderRepository;

public class OrderServiceImpl extends BaseServiceImpl<Order, Long, OrderRepository> {

    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }
}
