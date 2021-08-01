package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.ProductAttribute;
import ir.maktab.store.repository.ProductAttributeRepository;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class ProductAttributeRepositoryImpl extends BaseRepositoryImpl<ProductAttribute, Long> implements ProductAttributeRepository {

    public ProductAttributeRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(ProductAttribute order) {
        return null;
    }

    @Override
    public Boolean update(ProductAttribute order) {
        return null;
    }

    @Override
    public List<ProductAttribute> findAll() {
        return null;
    }

    @Override
    public List<ProductAttribute> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public ProductAttribute findByID(Long aLong) {
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

    @Override
    public List<ProductAttribute> findAllByProductId() {
        return null;
    }
}
