package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.domain.ProductAttribute;
import ir.maktab.repository.ProductAttributeRepository;

public class ProductAttributeServiceImpl extends BaseServiceImpl<ProductAttribute, Long, ProductAttributeRepository> {

    public ProductAttributeServiceImpl(ProductAttributeRepository repository) {
        super(repository);
    }
}
