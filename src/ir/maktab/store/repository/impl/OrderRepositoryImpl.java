package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.Order;
import ir.maktab.store.repository.OrderRepository;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Order, Long> implements OrderRepository {

    public OrderRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public List<Order> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public Order findByID(Long aLong) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }

    @Override
    public Boolean isExist(Long aLong) {
        return null;
    }
}
