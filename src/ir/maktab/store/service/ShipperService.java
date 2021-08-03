package ir.maktab.store.service;

import ir.maktab.store.base.service.BaseService;
import ir.maktab.store.domain.Shipper;

import java.sql.SQLException;

public interface ShipperService extends BaseService<Shipper, Integer> {
    Shipper chooseShipper() throws SQLException;
}
