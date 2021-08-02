package ir.maktab.store;


import ir.maktab.store.front.menu.FirstMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainApp {

    private static Connection connection;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/store_app", "root", "milad5050062330");
        ApplicationContext.databaseInitializer.createTables(connection);
        new FirstMenu().runMenu();
        /*MainCategoryService.addFirstCategories();
        CategoryService.addFirstCategories();*/
        /*new FirstMenu().runMenu();*/
        connection.close();
    }

    public static Connection getConnection() {
        return connection;
    }
}
