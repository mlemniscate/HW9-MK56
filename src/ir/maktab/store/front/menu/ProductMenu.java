/*
package ir.maktab.store.front.menu;

import ir.maktab.domain.Customer;
import ir.maktab.domain.Product;
import ir.maktab.util.service.ProductService;
import ir.maktab.util.service.TakenProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductMenu extends Menu implements RunnableMenu{
    private Customer customer;
    private List<Product> products;

    public ProductMenu(Customer customer, List<Product> products) {
        super(new String[]{"Add a Product to Cart", "Show Cart", "Back"});
        this.customer = customer;
        this.products = products;
        ProductService.showProducts(products);
    }

    @Override
    public Object runMenu() throws SQLException {
        while (true) {
            showMenu();
            switch (getChosenItem()) {
                case 1:
                        ProductService.chooseProduct(products, customer);
                        ProductService.showProducts(products);
                    break;
                case 2:
                    TakenProductService.showTakenProducts(customer);
                    break;
                case 3:
                    return null;
            }
        }
    }
}
*/
