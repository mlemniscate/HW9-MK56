package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.domain.Customer;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> {

    protected CustomerRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public List<Customer> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public Customer findByID(Long aLong) {
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
