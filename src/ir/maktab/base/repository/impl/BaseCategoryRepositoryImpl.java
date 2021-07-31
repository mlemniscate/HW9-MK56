package ir.maktab.base.repository.impl;

import ir.maktab.base.domain.BaseEntity;
import ir.maktab.base.repository.BaseCategoryRepository;

import java.sql.Connection;

public abstract class BaseCategoryRepositoryImpl<E extends BaseEntity<ID>, ID>
        extends BaseRepositoryImpl<E, ID>
        implements BaseCategoryRepository<E, ID> {

    protected BaseCategoryRepositoryImpl(Connection connection) {
        super(connection);
    }
}
