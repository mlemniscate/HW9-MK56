package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseProductServiceImpl;
import ir.maktab.store.domain.ProductAttribute;
import ir.maktab.store.domain.PurchasedProduct;
import ir.maktab.store.repository.PurchasedProductRepository;
import ir.maktab.store.service.PurchasedProductService;

public class PurchasedProductServiceImpl extends BaseProductServiceImpl<PurchasedProduct, PurchasedProductRepository>
implements PurchasedProductService {

    private final PurchasedProductRepository repository;

    public PurchasedProductServiceImpl(PurchasedProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public void saveAttribute(ProductAttribute attribute) {
        repository.saveAttribute(attribute);
    }
}
