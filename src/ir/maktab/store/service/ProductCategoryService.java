package ir.maktab.store.service;

import ir.maktab.store.base.service.BaseService;
import ir.maktab.store.domain.ProductCategory;

import java.sql.SQLException;

public interface ProductCategoryService extends BaseService<ProductCategory, Integer> {
    ProductCategory getCategory() throws SQLException;
}
