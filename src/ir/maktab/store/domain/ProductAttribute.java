package ir.maktab.store.domain;

import ir.maktab.store.base.domain.BaseEntity;

public class ProductAttribute extends BaseEntity<Long> {
    private String attributeName;
    private String attributeValue;

    public ProductAttribute(String attributeName, String attributeValue) {
        this(0L, attributeName, attributeValue);
    }

    public ProductAttribute(Long aLong, String attributeName, String attributeValue) {
        super(aLong);
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    @Override
    public String toString() {
        return attributeName + ": " + attributeValue;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
