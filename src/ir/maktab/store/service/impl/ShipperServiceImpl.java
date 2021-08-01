package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.Shipper;
import ir.maktab.store.repository.ShipperRepository;

public class ShipperServiceImpl extends BaseServiceImpl<Shipper, Integer, ShipperRepository> {

    public ShipperServiceImpl(ShipperRepository repository) {
        super(repository);
    }
}
