package ir.maktab.store;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private static final String CREATE_ORDERS_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `store_app`.`orders` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `customers_id` INT NOT NULL,\n" +
            "  `order_date` DATE NOT NULL,\n" +
            "  `shipping_date` DATE NULL,\n" +
            "  `delivery_date` DATE NULL,\n" +
            "  `shippers_id` INT NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  INDEX `fk_orders_customers1_idx` (`customers_id` ASC) VISIBLE,\n" +
            "  INDEX `fk_orders_shippers1_idx` (`shippers_id` ASC) VISIBLE,\n" +
            "  CONSTRAINT `fk_orders_customers1`\n" +
            "    FOREIGN KEY (`customers_id`)\n" +
            "    REFERENCES `store_app`.`customers` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `fk_orders_shippers1`\n" +
            "    FOREIGN KEY (`shippers_id`)\n" +
            "    REFERENCES `store_app`.`shippers` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB";

    private static final String CREATE_PRODUCTS_PURCHASED_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `store_app`.`products_purchased` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `product_name` VARCHAR(45) NOT NULL,\n" +
            "  `price` DOUBLE NOT NULL,\n" +
            "  `quantity` INT NOT NULL,\n" +
            "  `orders_id` INT NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  INDEX `fk_products_purchased_orders1_idx` (`orders_id` ASC) VISIBLE,\n" +
            "  CONSTRAINT `fk_products_purchased_orders1`\n" +
            "    FOREIGN KEY (`orders_id`)\n" +
            "    REFERENCES `store_app`.`orders` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB";

    private static final String CREATE_CUSTOMERS_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `store_app`.`customers` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `first_name` VARCHAR(45) NOT NULL,\n" +
            "  `last_name` VARCHAR(45) NOT NULL,\n" +
            "  `username` VARCHAR(45) NOT NULL,\n" +
            "  `password` VARCHAR(45) NOT NULL,\n" +
            "  `balance` DOUBLE NOT NULL,\n" +
            "  `is_deleted` TINYINT(1) NULL,\n" +
            "  PRIMARY KEY (`id`))\n" +
            "ENGINE = InnoDB";

    private static final String CREATE_CARTS_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `store_app`.`carts` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `customers_id` INT NOT NULL,\n" +
            "  `created_date` DATE NOT NULL,\n" +
            "  `last_updated_date` DATE NOT NULL,\n" +
            "  `is_deleted` TINYINT(1) NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  INDEX `fk_carts_customers_idx` (`customers_id` ASC) VISIBLE,\n" +
            "  CONSTRAINT `fk_carts_customers`\n" +
            "    FOREIGN KEY (`customers_id`)\n" +
            "    REFERENCES `store_app`.`customers` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB";


    private static final String CREATE_CATEGORIES_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `store_app`.`categories` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `parent_id` INT NOT NULL,\n" +
            "  `category_name` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id`))\n" +
            "ENGINE = InnoDB";

    private static final String CREATE_SHIPPERS_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `store_app`.`shippers` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `shipper_name` VARCHAR(45) NULL,\n" +
            "  `phone_number` VARCHAR(45) NULL,\n" +
            "  `price` DOUBLE NULL,\n" +
            "  `delivery_day` INT NULL,\n" +
            "  PRIMARY KEY (`id`))\n" +
            "ENGINE = InnoDB";

    private static final String CREATE_PRODUCTS_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `store_app`.`products` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `categories_id` INT NOT NULL,\n" +
            "  `product_name` VARCHAR(45) NOT NULL,\n" +
            "  `price` DOUBLE NOT NULL,\n" +
            "  `stock` INT NOT NULL,\n" +
            "  `is_deleted` TINYINT(1) NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  INDEX `fk_products_categories1_idx` (`categories_id` ASC) VISIBLE,\n" +
            "  CONSTRAINT `fk_products_categories1`\n" +
            "    FOREIGN KEY (`categories_id`)\n" +
            "    REFERENCES `store_app`.`categories` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB";

    private static final String CREATE_PRODUCTS_ATTRIBUTES_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `store_app`.`product_attributes` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `attribute_name` VARCHAR(45) NOT NULL,\n" +
            "  `attribute_value` VARCHAR(45) NOT NULL,\n" +
            "  `is_deleted` TINYINT(1) NULL,\n" +
            "  PRIMARY KEY (`id`))\n" +
            "ENGINE = InnoDB";

    private static final String CREATE_PRODUCTS_PURCHASED_ATTRIBUTES_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `store_app`.`products_purchased_attributes` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `attribute_name` VARCHAR(45) NOT NULL,\n" +
            "  `attribute_value` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id`))\n" +
            "ENGINE = InnoDB";

    private static final String CREATE_PRODUCTS_HAS_ATTRIBUTES_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `store_app`.`products_has_attributes` (\n" +
            "  `products_id` INT NOT NULL,\n" +
            "  `product_attributes_id` INT NOT NULL,\n" +
            "  PRIMARY KEY (`products_id`, `product_attributes_id`),\n" +
            "  INDEX `fk_products_has_product_atributes_product_atributes1_idx` (`product_attributes_id` ASC) VISIBLE,\n" +
            "  INDEX `fk_products_has_product_atributes_products1_idx` (`products_id` ASC) VISIBLE,\n" +
            "  CONSTRAINT `fk_products_has_product_atributes_products1`\n" +
            "    FOREIGN KEY (`products_id`)\n" +
            "    REFERENCES `store_app`.`products` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `fk_products_has_product_atributes_product_atributes1`\n" +
            "    FOREIGN KEY (`product_attributes_id`)\n" +
            "    REFERENCES `store_app`.`product_attributes` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB";

    private static final String CREATE_PRODUCTS_PURCHASED_HAS_ATTRIBUTES_PURCHASED_ATTRIBUTES_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `store_app`.`products_purchased_has_products_purchased_attributes` (\n" +
            "  `products_purchased_attributes_id` INT NOT NULL,\n" +
            "  `products_purchased_id` INT NOT NULL,\n" +
            "  PRIMARY KEY (`products_purchased_attributes_id`, `products_purchased_id`),\n" +
            "  INDEX `fk_products_purchased_atributes_has_products_purchased_prod_idx` (`products_purchased_id` ASC) VISIBLE,\n" +
            "  INDEX `fk_products_purchased_atributes_has_products_purchased_prod_idx1` (`products_purchased_attributes_id` ASC) VISIBLE,\n" +
            "  CONSTRAINT `fk_products_purchased_atributes_has_products_purchased_produc1`\n" +
            "    FOREIGN KEY (`products_purchased_attributes_id`)\n" +
            "    REFERENCES `store_app`.`products_purchased_attributes` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `fk_products_purchased_atributes_has_products_purchased_produc2`\n" +
            "    FOREIGN KEY (`products_purchased_id`)\n" +
            "    REFERENCES `store_app`.`products_purchased` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB";

    private static final String CREATE_CARTS_HAS_PRODUCTS_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `store_app`.`carts_has_products` (\n" +
            "  `products_id` INT NOT NULL,\n" +
            "  `carts_id` INT NOT NULL,\n" +
            "  `quantity` INT NOT NULL,\n" +
            "  PRIMARY KEY (`products_id`, `carts_id`),\n" +
            "  INDEX `fk_products_has_carts_carts1_idx` (`carts_id` ASC) VISIBLE,\n" +
            "  INDEX `fk_products_has_carts_products1_idx` (`products_id` ASC) VISIBLE,\n" +
            "  CONSTRAINT `fk_products_has_carts_products1`\n" +
            "    FOREIGN KEY (`products_id`)\n" +
            "    REFERENCES `store_app`.`products` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `fk_products_has_carts_carts1`\n" +
            "    FOREIGN KEY (`carts_id`)\n" +
            "    REFERENCES `store_app`.`carts` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB";

    public void createTables(Connection connection) throws SQLException {
        initCustomersTable(connection.createStatement());
        initShippersTable(connection.createStatement());
        initCategoryTable(connection.createStatement());
        initProductAttributesTable(connection.createStatement());
        initProductsTable(connection.createStatement());
        initProductsHasAttributesTable(connection.createStatement());
        initCartsTable(connection.createStatement());
        initCartsHasProductsTable(connection.createStatement());
        initOrderTable(connection.createStatement());
        initProductPurchasedTable(connection.createStatement());
        initProductPurchasedAttributesTable(connection.createStatement());
        initProductPurchasedHasProductPurchasedAttributesTable(connection.createStatement());
    }

    private void initCartsTable(Statement statement) {
        try (statement) {
            statement.executeUpdate(CREATE_CARTS_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("You have a problem in your customers table queries.");
            e.printStackTrace();
        }
    }

    private void initProductsHasAttributesTable(Statement statement) {
        try (statement) {
            statement.executeUpdate(CREATE_PRODUCTS_HAS_ATTRIBUTES_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("You have a problem in your customers table queries.");
            e.printStackTrace();
        }
    }

    private void initProductAttributesTable(Statement statement) {
        try (statement) {
            statement.executeUpdate(CREATE_PRODUCTS_ATTRIBUTES_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("You have a problem in your customers table queries.");
            e.printStackTrace();
        }
    }

    private void initCustomersTable(Statement statement) {
        try (statement) {
            statement.executeUpdate(CREATE_CUSTOMERS_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("You have a problem in your customers table queries.");
            e.printStackTrace();
        }
    }

    private void initShippersTable(Statement statement) {
        try (statement) {
            statement.executeUpdate(CREATE_SHIPPERS_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("You have a problem in your shippers table queries.");
            e.printStackTrace();
        }
    }

    private void initCategoryTable(Statement statement) {
        try (statement) {
            statement.executeUpdate(CREATE_CATEGORIES_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("You have a problem in your category table queries.");
            e.printStackTrace();
        }
    }

    private void initOrderTable(Statement statement) throws SQLException {
        try (statement) {
            statement.executeUpdate(CREATE_ORDERS_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("You have a problem in your orders table queries.");
            e.printStackTrace();
        }
    }

    private void initProductPurchasedTable(Statement statement) throws SQLException {
        try (statement) {
            statement.executeUpdate(CREATE_PRODUCTS_PURCHASED_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("You have a problem in your product_purchased table queries.");
            e.printStackTrace();
        }
    }

    private void initProductPurchasedAttributesTable(Statement statement) throws SQLException {
        try (statement) {
            statement.executeUpdate(CREATE_PRODUCTS_PURCHASED_ATTRIBUTES_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("You have a problem in your product_purchased table queries.");
            e.printStackTrace();
        }
    }

    private void initProductPurchasedHasProductPurchasedAttributesTable(Statement statement) throws SQLException {
        try (statement) {
            statement.executeUpdate(CREATE_PRODUCTS_PURCHASED_HAS_ATTRIBUTES_PURCHASED_ATTRIBUTES_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("You have a problem in your product_purchased table queries.");
            e.printStackTrace();
        }
    }

    private void initProductsTable(Statement statement) throws SQLException {
        try (statement) {
            statement.executeUpdate(CREATE_PRODUCTS_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("You have a problem in your products table queries.");
            e.printStackTrace();
        }
    }

    private void initCartsHasProductsTable(Statement statement) throws SQLException {
        try (statement) {
            statement.executeUpdate(CREATE_CARTS_HAS_PRODUCTS_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("You have a problem in your taken_products table queries.");
            e.printStackTrace();
        }
    }
}
