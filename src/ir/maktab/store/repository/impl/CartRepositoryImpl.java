package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.repository.CartRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class CartRepositoryImpl extends BaseRepositoryImpl<Cart, Long> implements CartRepository {

    private static final String INSERT_QUERY = "INSERT INTO carts (customers_id, created_date, last_updated_date)" +
            "VALUES (?, ?, ?)";

    private final Connection connection;

    public CartRepositoryImpl(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public Boolean save(Cart cart) {
        int insertResult = 0;
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);) {
            statement.setLong(1, cart.getCustomerId());
            statement.setDate(2, cart.getCreatedDate());
            statement.setDate(3, cart.getLastUpdatedDate());
            insertResult = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertResult > 0;
    }

    @Override
    public Boolean update(Cart customer) {
        return null;
    }

    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public List<Cart> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public Cart findByID(Long aLong) {
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
