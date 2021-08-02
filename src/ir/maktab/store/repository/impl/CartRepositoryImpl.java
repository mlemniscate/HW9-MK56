package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.domain.Product;
import ir.maktab.store.repository.CartRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartRepositoryImpl extends BaseRepositoryImpl<Cart, Long> implements CartRepository {

    private static final String INSERT_QUERY = "INSERT INTO carts (customers_id, created_date, last_updated_date)" +
            "VALUES (?, ?, ?)";
    private static final String SELECT_BY_CUSTOMER_ID = "SELECT * FROM store_app.carts c\n" +
            "JOIN store_app.carts_has_products cp ON c.id = cp.carts_id\n" +
            "JOIN store_app.products p ON p.id = cp.products_id\n" +
            "WHERE c.customers_id = ?";

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
    public Cart findByCustomerId(Long customerId) {
        int insertResult = 0;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_CUSTOMER_ID);) {
            statement.setLong(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) return createCart(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Cart createCart(ResultSet resultSet) throws SQLException {
        return new Cart(
                resultSet.getLong("id"),
                resultSet.getDate("created_date"),
                resultSet.getDate("last_updated_date"),
                createProductMap(resultSet),
                resultSet.getInt("product_limit")
        );
    }

    private Map<Product, Integer> createProductMap(ResultSet resultSet) throws SQLException {
        Map<Product, Integer> products = new HashMap<>();
        do{
            products.put(new Product(
                    resultSet.getLong("products_id"),
                    resultSet.getString("product_name"),
                    resultSet.getDouble("price"),
                    new ProductAttributeRepositoryImpl(connection).findAllByProductId(resultSet.getLong("product_id")),
                    resultSet.getInt("categories_id"),
                    resultSet.getInt("stock")
            ), resultSet.getInt("quantity"));
        } while (resultSet.next());
        return products;
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
