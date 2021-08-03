package ir.maktab.store.repository;

import ir.maktab.store.base.repository.BaseRepository;
import ir.maktab.store.domain.ProductAttribute;

import java.util.List;

public interface ProductAttributeRepository extends BaseRepository<ProductAttribute, Long> {
    List<ProductAttribute> findAllByProductId(Long productId);
}
