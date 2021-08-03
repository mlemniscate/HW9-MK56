package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.Shipper;
import ir.maktab.store.front.input.InputInt;
import ir.maktab.store.repository.ShipperRepository;
import ir.maktab.store.service.ShipperService;

import java.sql.SQLException;
import java.util.List;

public class ShipperServiceImpl extends BaseServiceImpl<Shipper, Integer, ShipperRepository> implements ShipperService {

    private final ShipperRepository repository;

    public ShipperServiceImpl(ShipperRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Shipper chooseShipper() throws SQLException {
        List<Shipper> shippers = showShippers();
        int chosenItem = new InputInt("Enter your shipper number: ", shippers.size(), 1, null).getIntInput() - 1;
        return shippers.get(chosenItem);
    }

    public List<Shipper> showShippers() throws SQLException {
        List<Shipper> shippers = getShippers();
        for (int i = 0; i < shippers.size(); i++) {
            System.out.printf("#%d%n%s%n", (i+1), shippers.get(i).toString());
        }
        return shippers;
    }

    private List<Shipper> getShippers() throws SQLException {
        return findAll();
    }
}
