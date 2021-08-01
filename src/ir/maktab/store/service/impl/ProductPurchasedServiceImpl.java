package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseProductServiceImpl;
import ir.maktab.store.domain.ProductPurchased;
import ir.maktab.store.repository.ProductPurchasedRepository;

public class ProductPurchasedServiceImpl extends BaseProductServiceImpl<ProductPurchased, ProductPurchasedRepository> {

    public ProductPurchasedServiceImpl(ProductPurchasedRepository repository) {
        super(repository);
    }
}
