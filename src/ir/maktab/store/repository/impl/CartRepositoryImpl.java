package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.repository.CartRepository;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class CartRepositoryImpl extends BaseRepositoryImpl<Cart, Long> implements CartRepository {

    public CartRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Cart save(Cart customer) {
        return null;
    }

    @Override
    public Cart update(Cart customer) {
        return null;
    }

    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public List<Cart> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public Cart findByID(Long aLong) {
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
