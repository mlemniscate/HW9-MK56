package ir.maktab.store;

import ir.maktab.store.repository.impl.*;
import ir.maktab.store.service.impl.*;

public class ApplicationContext {

    public static final DatabaseInitializer databaseInitializer = new DatabaseInitializer();

    public static final CartServiceImpl cartService = new CartServiceImpl(new CartRepositoryImpl(MainApp.getConnection()));

    public static final CustomerServiceImpl customerService = new CustomerServiceImpl(new CustomerRepositoryImpl(MainApp.getConnection()));

    public static final OrderServiceImpl orderService = new OrderServiceImpl(new OrderRepositoryImpl(MainApp.getConnection()));

    public static final ProductServiceImpl productService = new ProductServiceImpl(new ProductRepositoryImpl(MainApp.getConnection()));

    public static final ProductAttributeServiceImpl productAttributeService = new ProductAttributeServiceImpl(new ProductAttributeRepositoryImpl(MainApp.getConnection()));

    public static final ProductCategoryServiceImpl productCategoryService = new ProductCategoryServiceImpl(new ProductCategoryRepositoryImpl(MainApp.getConnection()));

    public static final ProductPurchasedServiceImpl productPurchasedService = new ProductPurchasedServiceImpl(new ProductPurchasedRepositoryImpl(MainApp.getConnection()));

    public static final ShipperServiceImpl shipperService = new ShipperServiceImpl(new ShipperRepositoryImpl(MainApp.getConnection()));

}
