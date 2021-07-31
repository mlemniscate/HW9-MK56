package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;

import java.util.List;

public class ProductCategory extends BaseEntity<Integer> {

    private List<ProductCategory> productCategories;
    private ProductCategory parent;
}
