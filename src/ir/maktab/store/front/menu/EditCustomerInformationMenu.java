/*
package ir.maktab.store.front.menu;

import ir.maktab.domain.Customer;
import ir.maktab.util.service.CustomerService;

import java.sql.SQLException;

public class EditCustomerInformationMenu extends Menu implements RunnableMenu<Void>{
    Customer user;

    public EditCustomerInformationMenu(Customer customer) {
        super(new String[]{"Edit first name", "Edit last name", "Edit username", "Edit password", "Back"});
        this.user = customer;
    }

    @Override
    public Void runMenu() throws SQLException {
        while (true) {
            showMenu();
            switch (getChosenItem()) {
                case 1:
                    CustomerService.editFirstName(user);
                    break;
                case 2:
                    CustomerService.editLastName(user);
                    break;
                case 3:
                    CustomerService.editUsername(user);
                    break;
                case 4:
                    CustomerService.editPassword(user);
                    break;
                case 5:
                    CustomerService.update(user);
                    return null;
            }
        }
    }
}
*/
