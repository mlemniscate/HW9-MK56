package ir.maktab.domain;

import java.util.List;

public class ProductCategory extends Category<ProductCategory>{

    public ProductCategory(List<ProductCategory> categories, ProductCategory parent) {
        super(categories, parent);
    }

    public ProductCategory(Integer id, List<ProductCategory> categories, ProductCategory parent) {
        super(id, categories, parent);
    }
}
