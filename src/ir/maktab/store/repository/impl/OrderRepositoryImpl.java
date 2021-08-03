package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.Order;
import ir.maktab.store.repository.OrderRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Order, Long> implements OrderRepository {

    private static final String INSERT_QUERY = "INSERT INTO customers (customers_id, order_date, shippers_id)" +
            "VALUES (?, ?, ?)";

    private final Connection connection;

    public OrderRepositoryImpl(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public Boolean save(Order order) {
        boolean isInserted = false;
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);) {
            connection.setAutoCommit(false);
            statement.setLong(1, order.getCustomerId());
            statement.setDate(2, order.getOrderDate());
            statement.setInt(3, order.getShipper().getId());
            isInserted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInserted;
    }

    @Override
    public Boolean update(Order order) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public List<Order> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public Order findByID(Long aLong) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }

    @Override
    public Boolean isExist(Long aLong) {
        return null;
    }
}
