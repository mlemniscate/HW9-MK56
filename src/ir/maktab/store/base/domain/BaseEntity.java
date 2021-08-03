package ir.maktab.store.base.domain;

public class BaseEntity<ID> {

    private ID id;
    private Boolean isDeleted;

    public BaseEntity() {
    }

    public BaseEntity(ID id) {
        this.id = id;
    }

    public BaseEntity(ID id, Boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
