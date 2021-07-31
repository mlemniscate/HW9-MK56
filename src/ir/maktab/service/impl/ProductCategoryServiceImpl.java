package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.domain.ProductCategory;
import ir.maktab.repository.ProductCategoryRepository;

public class ProductCategoryServiceImpl extends BaseServiceImpl<ProductCategory, Integer, ProductCategoryRepository> {

    public ProductCategoryServiceImpl(ProductCategoryRepository repository) {
        super(repository);
    }
}
