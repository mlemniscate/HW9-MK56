package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.domain.Shipper;
import ir.maktab.repository.ShipperRepository;

public class ShipperServiceImpl extends BaseServiceImpl<Shipper, Integer, ShipperRepository> {

    public ShipperServiceImpl(ShipperRepository repository) {
        super(repository);
    }
}
