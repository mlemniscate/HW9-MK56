package ir.maktab.store.controler.menu;

import ir.maktab.domain.Customer;
import ir.maktab.util.service.CustomerService;

import java.sql.SQLException;
import java.util.Objects;

/**
 * FirstMenu class for starting program and first menu of the program.
 */
public class FirstMenu extends Menu implements RunnableMenu<Void> {

    public FirstMenu() {
        super(new String[]{"Login", "Sign Up", "Exit"});
    }

    // This method do all the first menu tasks
    @Override
    public Void runMenu() throws SQLException {
        while (true) {
            showMenu();
            switch (getChosenItem()) {
                case 1:
                    Customer customer = CustomerService.login();
                    if(!Objects.isNull(customer))
                        new CustomerMenu(customer).runMenu();
                    break;
                case 2:
                    CustomerService.signUp();
                    break;
                case 3:
                    if (new CheckMenu("Are you sure you want to exit?").runMenu()) return null;
                    else break;
            }
        }
    }
}