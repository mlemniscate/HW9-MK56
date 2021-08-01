package ir.maktab.store.service;

import ir.maktab.store.base.service.BaseProductService;
import ir.maktab.store.domain.Product;

import java.util.List;

public interface ProductService extends BaseProductService<Product> {
    List<Product> getProducts(Integer categoryId);
}
