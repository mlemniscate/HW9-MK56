package ir.maktab.store.domain;

import ir.maktab.store.base.domain.BaseEntity;

public class ProductCategory extends BaseEntity<Integer> {

    private String categoryName;
    private Integer parentId;

    public ProductCategory(String categoryName, Integer parentId) {
        this.categoryName = categoryName;
        this.parentId = parentId;
    }

    public ProductCategory(Integer id, String categoryName, Integer parentId) {
        super(id);
        this.categoryName = categoryName;
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
