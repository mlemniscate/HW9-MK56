package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.domain.ProductAttribute;
import ir.maktab.repository.ProductAttributeRepository;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class ProductAttributeRepositoryImpl extends BaseRepositoryImpl<ProductAttribute, Long> implements ProductAttributeRepository {

    protected ProductAttributeRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public ProductAttribute save(ProductAttribute order) {
        return null;
    }

    @Override
    public ProductAttribute update(ProductAttribute order) {
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
}