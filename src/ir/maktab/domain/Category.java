package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;

import java.util.List;

public abstract class Category<T extends Category<T>> extends BaseEntity<Integer> {

    private List<T> categories;
    private T parent;

    public Category(List<T> categories, T parent) {
        this(0, categories, parent);
    }

    public Category(Integer id, List<T> categories, T parent) {
        super(id);
        this.categories = categories;
        this.parent = parent;
    }

    public List<T> getCategories() {
        return categories;
    }

    public void setCategories(List<T> categories) {
        this.categories = categories;
    }

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }
}
