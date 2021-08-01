package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.Shipper;
import ir.maktab.store.repository.ShipperRepository;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class ShipperRepositoryImpl extends BaseRepositoryImpl<Shipper, Integer> implements ShipperRepository {

    public ShipperRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Shipper save(Shipper productCategory) {
        return null;
    }

    @Override
    public Shipper update(Shipper productCategory) {
        return null;
    }

    @Override
    public List<Shipper> findAll() {
        return null;
    }

    @Override
    public List<Shipper> findAllByIds(Collection<Integer> integers) {
        return null;
    }

    @Override
    public Shipper findByID(Integer integer) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer integer) {
        return null;
    }

    @Override
    public Boolean isExist(Integer integer) {
        return null;
    }
}
