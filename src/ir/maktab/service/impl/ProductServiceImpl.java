package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.domain.Product;
import ir.maktab.repository.ProductRepository;

public class ProductServiceImpl extends BaseServiceImpl<Product, Long, ProductRepository> {

    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }
}
