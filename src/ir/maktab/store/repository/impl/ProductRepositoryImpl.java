package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseProductRepositoryImpl;
import ir.maktab.store.domain.Product;
import ir.maktab.store.repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductRepositoryImpl extends BaseProductRepositoryImpl<Product> implements ProductRepository {

    private static final String SELECT_ALL_BY_CATEGORY_QUERY = "SELECT * FROM products WHERE categories_id = ? && is_deleted = 0";

    private Connection connection;

    public ProductRepositoryImpl(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public Boolean save(Product order) {
        return null;
    }

    @Override
    public Boolean update(Product order) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public Product findByID(Long aLong) {
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
    public List<Product> findAllByCategoryId(Integer categoryId) {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BY_CATEGORY_QUERY)) {
            statement.setLong(1, categoryId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                products.add(createObject(result));
            }
        } catch (SQLException e) {
            System.out.println("You have a problem in your customer select user pass query.");
            e.printStackTrace();
        }
        return products;
    }

    public Product createObject(ResultSet result) throws SQLException {
        return new Product(
                result.getLong("id"),
                result.getString("product_name"),
                result.getDouble("price"),
                new ProductAttributeRepositoryImpl(connection).findAllByProductId(result.getLong("id")),
                result.getInt("categories_id"),
                result.getInt("stock")
        );
    }
}
