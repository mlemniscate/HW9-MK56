package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseProductRepositoryImpl;
import ir.maktab.store.domain.PurchasedProduct;
import ir.maktab.store.repository.PurchasedProductRepository;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class PurchasedProductRepositoryImpl extends BaseProductRepositoryImpl<PurchasedProduct> implements PurchasedProductRepository {

    public PurchasedProductRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(PurchasedProduct order) {
        return null;
    }

    @Override
    public Boolean update(PurchasedProduct order) {
        return null;
    }

    @Override
    public List<PurchasedProduct> findAll() {
        return null;
    }

    @Override
    public List<PurchasedProduct> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public PurchasedProduct findByID(Long aLong) {
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
