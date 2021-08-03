package ir.maktab.store.repository;

import ir.maktab.store.base.repository.BaseProductRepository;
import ir.maktab.store.domain.ProductAttribute;
import ir.maktab.store.domain.PurchasedProduct;

public interface PurchasedProductRepository extends BaseProductRepository<PurchasedProduct> {
    boolean saveAttribute(ProductAttribute attribute);
}
