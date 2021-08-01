package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.ProductCategory;
import ir.maktab.store.repository.ProductCategoryRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductCategoryRepositoryImpl extends BaseRepositoryImpl<ProductCategory, Integer> implements ProductCategoryRepository {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM categories";

    private final Connection connection;

    public ProductCategoryRepositoryImpl(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public Boolean save(ProductCategory productCategory) {
        return null;
    }

    @Override
    public Boolean update(ProductCategory productCategory) {
        return null;
    }

    @Override
    public List<ProductCategory> findAll() throws SQLException {
        List<ProductCategory> productCategories = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(SELECT_ALL_QUERY);
            while (result.next()) {
                productCategories.add(createObject(result));
            }
        } catch (SQLException e) {
            System.out.println("You have a problem in your customer select user pass query.");
            e.printStackTrace();
        }
        return productCategories;
    }

    @Override
    public List<ProductCategory> findAllByIds(Collection<Integer> integers) {
        return null;
    }

    @Override
    public ProductCategory findByID(Integer integer) {
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

    public ProductCategory createObject(ResultSet result) throws SQLException {
        return new ProductCategory(
                result.getInt("id"),
                result.getString("category_name"),
                result.getInt("parent_id")
        );
    }
}
