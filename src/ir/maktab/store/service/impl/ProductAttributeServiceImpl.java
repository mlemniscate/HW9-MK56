package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.ProductAttribute;
import ir.maktab.store.repository.ProductAttributeRepository;

public class ProductAttributeServiceImpl extends BaseServiceImpl<ProductAttribute, Long, ProductAttributeRepository> {

    public ProductAttributeServiceImpl(ProductAttributeRepository repository) {
        super(repository);
    }
}
