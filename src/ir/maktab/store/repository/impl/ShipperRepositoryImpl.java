package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.Shipper;
import ir.maktab.store.repository.ShipperRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShipperRepositoryImpl extends BaseRepositoryImpl<Shipper, Integer> implements ShipperRepository {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM shippers";

    private final Connection connection;

    public ShipperRepositoryImpl(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public Boolean save(Shipper productCategory) {
        return null;
    }

    @Override
    public Boolean update(Shipper productCategory) {
        return null;
    }

    @Override
    public List<Shipper> findAll() {
        List<Shipper> shippers = new ArrayList<>();
        try(Statement statement = connection.createStatement();) {
            ResultSet result = statement.executeQuery(SELECT_ALL_QUERY);
            while(result.next()) {
                shippers.add(createObject(result));
            }
            return shippers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shippers;
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

    public Shipper createObject(ResultSet result) throws SQLException {
        return new Shipper(
                result.getInt("id"),
                result.getString("shipper_name"),
                result.getString("phone_number"),
                result.getDouble("price"),
                result.getInt("delivery_day")
        );
    }
}
