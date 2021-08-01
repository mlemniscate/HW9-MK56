package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseProductRepositoryImpl;
import ir.maktab.store.domain.ProductPurchased;
import ir.maktab.store.repository.ProductPurchasedRepository;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class ProductPurchasedRepositoryImpl extends BaseProductRepositoryImpl<ProductPurchased> implements ProductPurchasedRepository {

    public ProductPurchasedRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(ProductPurchased order) {
        return null;
    }

    @Override
    public Boolean update(ProductPurchased order) {
        return null;
    }

    @Override
    public List<ProductPurchased> findAll() {
        return null;
    }

    @Override
    public List<ProductPurchased> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public ProductPurchased findByID(Long aLong) {
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
