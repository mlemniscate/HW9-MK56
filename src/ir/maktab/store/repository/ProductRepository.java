package ir.maktab.store.repository;

import ir.maktab.store.base.repository.BaseProductRepository;
import ir.maktab.store.domain.Product;

import java.util.List;

public interface ProductRepository extends BaseProductRepository<Product> {
    List<Product> findAllByCategoryId(Integer categoryId);
}
