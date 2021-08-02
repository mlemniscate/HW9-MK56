package ir.maktab.store.front.menu;


import ir.maktab.store.ApplicationContext;
import ir.maktab.store.domain.Customer;
import ir.maktab.store.domain.Product;

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
                /*case 1:
                    new ShowCartMenu(customer).runMenu();
                    break;*/
                case 2:
                    Product product = ApplicationContext.productService.getProduct();
                    ApplicationContext.cartService.addProductToCart(product);
                    break;
                case 3:
                    ApplicationContext.customerService.depositBalance(customer);
                    break;
                /*case 4:
                    new EditCustomerInformationMenu(customer).runMenu();
                    break;*/
                case 5:
                    if(new CheckMenu("Are you sure you want to log out?").runMenu()) return null;
                    else break;
            }
        }
    }

    private void chooseProduct() throws SQLException {


    }
}


