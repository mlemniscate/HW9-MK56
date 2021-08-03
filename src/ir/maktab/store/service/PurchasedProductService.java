package ir.maktab.store.service;

import ir.maktab.store.base.service.BaseProductService;
import ir.maktab.store.domain.ProductAttribute;
import ir.maktab.store.domain.PurchasedProduct;

public interface PurchasedProductService extends BaseProductService<PurchasedProduct> {
    void saveAttribute(ProductAttribute attribute);
}
