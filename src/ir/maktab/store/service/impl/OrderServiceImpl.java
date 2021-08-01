package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.Order;
import ir.maktab.store.repository.OrderRepository;

public class OrderServiceImpl extends BaseServiceImpl<Order, Long, OrderRepository> {

    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }
}
