package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseProductServiceImpl;
import ir.maktab.store.domain.Product;
import ir.maktab.store.repository.ProductRepository;

public class ProductServiceImpl extends BaseProductServiceImpl<Product, ProductRepository> {

    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }
}
