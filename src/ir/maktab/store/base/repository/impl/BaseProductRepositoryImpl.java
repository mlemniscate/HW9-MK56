package ir.maktab.store.base.repository.impl;

import ir.maktab.store.base.domain.BaseProduct;
import ir.maktab.store.base.repository.BaseProductRepository;

import java.sql.Connection;

public abstract class BaseProductRepositoryImpl<E extends BaseProduct<E>> implements
        BaseProductRepository<E> {

    private final Connection connection;

    protected BaseProductRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
}
