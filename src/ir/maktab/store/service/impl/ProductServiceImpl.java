package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseProductServiceImpl;
import ir.maktab.store.domain.Product;
import ir.maktab.store.repository.ProductRepository;
import ir.maktab.store.service.ProductService;

import java.util.List;

public class ProductServiceImpl extends BaseProductServiceImpl<Product, ProductRepository> implements ProductService {

    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
        this.repository = repository;
    }


    @Override
    public List<Product> getProducts(Integer categoryId) {
//        return repository.;
        return null;
    }
}
