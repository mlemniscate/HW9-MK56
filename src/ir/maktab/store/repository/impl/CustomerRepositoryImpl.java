package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.Customer;
import ir.maktab.store.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> implements CustomerRepository {

    private static final String SELECT_ONE_USER_PASS_QUERY = "SELECT * FROM customers WHERE username = ? && password = ? && is_deleted = 0";
    private static final String INSERT_QUERY = "INSERT INTO customers (first_name, last_name, username, password, balance)" +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM customers WHERE is_deleted = 0";
    private static final String UPDATE_QUERY = "UPDATE customers " +
            "SET first_name = ?, last_name = ?, username = ?, password = ?, balance = ? " +
            "WHERE id = ? && is_deleted = 0";

    private final Connection connection;

    public CustomerRepositoryImpl(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public Boolean save(Customer customer) {
        int insertResult = 0;
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getUsername());
            statement.setString(4, customer.getPassword());
            statement.setDouble(5, customer.getBalance());
            insertResult = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertResult > 0;
    }

    @Override
    public Boolean update(Customer customer) {
        int insertResult = 0;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getUsername());
            statement.setString(4, customer.getPassword());
            statement.setDouble(5, customer.getBalance());
            statement.setLong(6, customer.getId());
            insertResult = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertResult > 0;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = null;
        try (Statement statement = connection.createStatement()) {
            customers = new ArrayList<>();
            ResultSet result = statement.executeQuery(SELECT_ALL_QUERY);
            while(result.next()) {
                customers.add(createObject(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
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

}
