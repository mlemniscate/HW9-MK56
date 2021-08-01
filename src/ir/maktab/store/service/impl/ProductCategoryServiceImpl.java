package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.ProductCategory;
import ir.maktab.store.repository.ProductCategoryRepository;

public class ProductCategoryServiceImpl extends BaseServiceImpl<ProductCategory, Integer, ProductCategoryRepository> {

    public ProductCategoryServiceImpl(ProductCategoryRepository repository) {
        super(repository);
    }
}
