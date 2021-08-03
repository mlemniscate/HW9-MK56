package ir.maktab.store.front.menu;


import ir.maktab.store.ApplicationContext;
import ir.maktab.store.domain.Customer;
import ir.maktab.store.service.CustomerService;

import java.sql.SQLException;

public class EditCustomerInformationMenu extends Menu implements RunnableMenu<Void>{
    private Customer customer;

    public EditCustomerInformationMenu(Customer customer) {
        super(new String[]{"Edit first name", "Edit last name", "Edit username", "Edit password", "Back"});
        this.customer = customer;
    }

    @Override
    public Void runMenu() throws SQLException {
        while (true) {
            showMenu();
            switch (getChosenItem()) {
                case 1:
                    ApplicationContext.customerService.editFirstName(customer);
                    break;
                case 2:
                    ApplicationContext.customerService.editLastName(customer);
                    break;
                case 3:
                    ApplicationContext.customerService.editUsername(customer);
                    break;
                case 4:
                    ApplicationContext.customerService.editPassword(customer);
                    break;
                case 5:
                    ApplicationContext.customerService.update(customer);
                    return null;
            }
        }
    }
}
