package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.Product;
import ir.maktab.store.repository.ProductRepository;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class ProductRepositoryImpl extends BaseRepositoryImpl<Product, Long> implements ProductRepository {

    protected ProductRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Product save(Product order) {
        return null;
    }

    @Override
    public Product update(Product order) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public Product findByID(Long aLong) {
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
