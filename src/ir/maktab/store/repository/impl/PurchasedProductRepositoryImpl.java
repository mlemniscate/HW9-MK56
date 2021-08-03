package ir.maktab.store.repository.impl;

import ir.maktab.store.base.repository.impl.BaseProductRepositoryImpl;
import ir.maktab.store.domain.ProductAttribute;
import ir.maktab.store.domain.PurchasedProduct;
import ir.maktab.store.repository.PurchasedProductRepository;

import java.sql.*;
import java.util.Collection;
import java.util.List;

public class PurchasedProductRepositoryImpl extends BaseProductRepositoryImpl<PurchasedProduct> implements PurchasedProductRepository {

    private static final String INSERT_ATTRIBUTE_QUERY = "INSERT INTO " +
            "products_purchased_has_products_purchased_attributes" +
            "(products_purchased_attributes_id, products_purchased_id, attribute_value) " +
            "VALUES(?, ?, ?)";

    private static final String GET_LAST_PRODUCT_ID_QUERY = "SELECT id FROM products_purchased " +
            "ORDER BY id DESC LIMIT 1";

    private final Connection connection;

    public PurchasedProductRepositoryImpl(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public Boolean save(PurchasedProduct order) {
        return null;
    }

    @Override
    public Boolean update(PurchasedProduct order) {
        return null;
    }

    @Override
    public List<PurchasedProduct> findAll() {
        return null;
    }

    @Override
    public List<PurchasedProduct> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public PurchasedProduct findByID(Long aLong) {
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
    public boolean saveAttribute(ProductAttribute attribute) {
        Long purchasedProductId = getLastProductId();
        int insertResult = 0;
        try (PreparedStatement statement = connection.prepareStatement(INSERT_ATTRIBUTE_QUERY);) {
            statement.setLong(1, attribute.getId());
            statement.setLong(2, purchasedProductId);
            statement.setString(3, attribute.getAttributeValue());
            insertResult = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertResult > 0;
    }

    private Long getLastProductId() {
        try (Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(GET_LAST_PRODUCT_ID_QUERY);
            if(resultSet.next()) return resultSet.getLong("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }
}
