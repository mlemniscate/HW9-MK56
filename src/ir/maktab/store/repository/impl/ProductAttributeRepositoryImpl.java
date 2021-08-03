package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.store.domain.ProductAttribute;
import ir.maktab.store.repository.ProductAttributeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductAttributeRepositoryImpl extends BaseRepositoryImpl<ProductAttribute, Long> implements ProductAttributeRepository {

    private static final String SELECT_PRODUCT_HAS_ATTRIBUTES = "SELECT * FROM store_app.products_has_attributes p\n" +
            "JOIN store_app.product_attributes a ON p.product_attributes_id = a.id\n" +
            "WHERE products_id = ? && a.is_deleted = 0 && p.is_deleted = 0";

    private final Connection connection;

    public ProductAttributeRepositoryImpl(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public Boolean save(ProductAttribute order) {
        return null;
    }

    @Override
    public Boolean update(ProductAttribute order) {
        return null;
    }

    @Override
    public List<ProductAttribute> findAll() {
        return null;
    }

    @Override
    public List<ProductAttribute> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public ProductAttribute findByID(Long aLong) {
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
    public List<ProductAttribute> findAllByProductId(Long productId) {
        List<ProductAttribute> productAttributes = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_HAS_ATTRIBUTES)) {
            productAttributes = new ArrayList<>();
            statement.setLong(1, productId);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                productAttributes.add(createObject(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productAttributes;
    }

    public ProductAttribute createObject(ResultSet result) throws SQLException {
        return new ProductAttribute(
                result.getLong("id"),
                result.getString("attribute_name"),
                result.getString("attribute_value")
        );
    }
}
