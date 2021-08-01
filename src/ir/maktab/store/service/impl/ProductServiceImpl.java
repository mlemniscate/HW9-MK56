package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.Product;
import ir.maktab.store.repository.ProductRepository;

public class ProductServiceImpl extends BaseServiceImpl<Product, Long, ProductRepository> {

    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }
}
