package ir.maktab.store.base.repository.impl;

import ir.maktab.store.base.domain.BaseEntity;
import ir.maktab.store.base.repository.BaseRepository;

import java.sql.Connection;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID> implements
        BaseRepository<E, ID> {

    private final Connection connection;

    protected BaseRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
}
