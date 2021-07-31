package ir.maktab.base.repository.impl;

import ir.maktab.base.domain.BaseEntity;
import ir.maktab.base.repository.BaseRepository;

import java.sql.Connection;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID> implements
        BaseRepository<E, ID> {

    private final Connection connection;

    protected BaseRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
}
