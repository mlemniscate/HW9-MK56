package ir.maktab.store.domain;

import ir.maktab.store.base.domain.BaseEntity;

import java.util.List;

public class ProductCategory extends BaseEntity<Integer> {

    private List<ProductCategory> productCategories;
    private ProductCategory parent;
}
