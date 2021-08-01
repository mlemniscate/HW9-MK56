package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.ProductCategory;
import ir.maktab.store.repository.ProductCategoryRepository;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class ProductCategoryRepositoryImpl extends BaseRepositoryImpl<ProductCategory, Integer> implements ProductCategoryRepository {

    protected ProductCategoryRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return null;
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        return null;
    }

    @Override
    public List<ProductCategory> findAll() {
        return null;
    }

    @Override
    public List<ProductCategory> findAllByIds(Collection<Integer> integers) {
        return null;
    }

    @Override
    public ProductCategory findByID(Integer integer) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer integer) {
        return null;
    }

    @Override
    public Boolean isExist(Integer integer) {
        return null;
    }
}
