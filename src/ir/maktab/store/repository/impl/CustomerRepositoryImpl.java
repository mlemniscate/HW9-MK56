package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.Customer;
import ir.maktab.store.repository.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> implements CustomerRepository {

    private static final String SELECT_ONE_USER_PASS_QUERY = "SELECT * FROM customers WHERE username = ? && password = ?";

    private final Connection connection;

    public CustomerRepositoryImpl(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public List<Customer> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public Customer findByID(Long aLong) {
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

    @Override
    public Customer findByUsernamePassword(String username, String password) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ONE_USER_PASS_QUERY)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if(result.next()) return createObject(result);
        } catch (SQLException e) {
            System.out.println("You have a problem in your customer select user pass query.");
            e.printStackTrace();
        }
        return null;
    }

    public Customer createObject(ResultSet result) throws SQLException {
        return new Customer(
                result.getLong("id"),
                result.getString("first_name"),
                result.getString("last_name"),
                result.getString("username"),
                result.getString("password"),
                result.getDouble("balance")
        );
    }
}
