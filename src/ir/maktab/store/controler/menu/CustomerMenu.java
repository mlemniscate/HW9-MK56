package ir.maktab.store.controler.menu;

import ir.maktab.domain.Category;
import ir.maktab.domain.Customer;
import ir.maktab.domain.MainCategory;
import ir.maktab.util.service.CategoryService;
import ir.maktab.util.service.CustomerService;
import ir.maktab.util.service.MainCategoryService;
import ir.maktab.util.service.ProductService;

import java.sql.SQLException;

public class CustomerMenu extends Menu implements RunnableMenu<Void>{
    private Customer customer;

    public CustomerMenu(Customer customer) {
        super(new String[]{"Show Cart and Payment", "Add Product to Cart", "Deposit Balance", "Edit Profile and Info", "Log Out"});
        this.customer = customer;
        System.out.printf("\n\nWelcome to your page %s %s.%n", customer.getFirstName(), customer.getLastName());
    }

    @Override
    public Void runMenu() throws SQLException {
        while (true) {
            showMenu();
            switch (getChosenItem()) {
                case 1:
                    new ShowCartMenu(customer).runMenu();
                    break;
                case 2:
                    MainCategory mainCategory = MainCategoryService.chooseMainCategory();
                    Category category = CategoryService.chooseCategory(mainCategory);
                    new ProductMenu(customer, ProductService.getProducts(category)).runMenu();
                    break;
                case 3:
                    CustomerService.depositBalance(customer);
                    break;
                case 4:
                    new EditCustomerInformationMenu(customer).runMenu();
                    break;
                case 5:
                    if(new CheckMenu("Are you sure you want to log out?").runMenu()) return null;
                    else break;
            }
        }
    }
}


