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
            "WHERE c.customers_id = ?";
    private static final String SELECT_CART_HAS_PRODUCTS_QUERY = "SELECT * FROM products p\n" +
            "JOIN carts_has_products c ON p.id = c.products_id\n" +
            "WHERE carts_id = ?";
    private static final String INSERT_PRODUCT_TO_CART_QUERY = "INSERT INTO carts_has_products(products_id, carts_id, quantity)" +
            "VALUES(?, ?, ?)";
    private static final String UPDATE_PRODUCT_IN_CART_QUERY = "UPDATE carts_has_products SET quantity = ? " +
            "WHERE products_id = ? && carts_id = ?";

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
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_CUSTOMER_ID);) {
            statement.setLong(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) return createCart(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveProduct(Long cartId, int quantity, Long productId) {
        int insertResult = 0;
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT_TO_CART_QUERY);) {
            statement.setLong(1, productId);
            statement.setLong(2, cartId);
            statement.setInt(3, quantity);
            insertResult = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertResult > 0;
    }

    @Override
    public boolean updateProduct(Long cartId, Long productId, Integer quantity) {
        int insertResult = 0;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_IN_CART_QUERY);) {
            statement.setInt(1, quantity);
            statement.setLong(2, productId);
            statement.setLong(3, cartId);
            insertResult = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertResult > 0;
    }

    private Cart createCart(ResultSet resultSet) throws SQLException {
        return new Cart(
                resultSet.getLong("id"),
                resultSet.getLong("customers_id"),
                resultSet.getDate("created_date"),
                resultSet.getDate("last_updated_date"),
                findCartHasProducts(resultSet.getLong("id")),
                resultSet.getInt("product_limit")
        );
    }

    private Map<Product, Integer> findCartHasProducts(Long cartId) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_CART_HAS_PRODUCTS_QUERY);) {
            statement.setLong(1, cartId);
            ResultSet resultSet = statement.executeQuery();
            return createProductMap(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Map<Product, Integer> createProductMap(ResultSet resultSet) throws SQLException {
        Map<Product, Integer> products = new HashMap<>();
        while (resultSet.next()) {
            products.put(new Product(
                    resultSet.getLong("products_id"),
                    resultSet.getString("product_name"),
                    resultSet.getDouble("price"),
                    new ProductAttributeRepositoryImpl(connection).findAllByProductId(resultSet.getLong("products_id")),
                    resultSet.getInt("categories_id"),
                    resultSet.getInt("stock")
            ), resultSet.getInt("quantity"));
        }
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
