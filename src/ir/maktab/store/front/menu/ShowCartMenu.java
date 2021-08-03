package ir.maktab.store.front.menu;


import ir.maktab.store.ApplicationContext;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.domain.Customer;

import java.sql.SQLException;

public class ShowCartMenu extends Menu implements RunnableMenu<Void>{
    private final Cart cart;
    private final Customer customer;

    public ShowCartMenu(Cart cart, Customer customer) {
        super(new String[]{"Delete Item", "Final Payment", "Back"});
        this.cart = cart;
        this.customer = customer;
        ApplicationContext.cartService.showCartProducts(cart);
    }

    @Override
    public Void runMenu() throws SQLException {
        while (true) {
            showMenu();
            switch (getChosenItem()) {
                case 1:
                    ApplicationContext.cartService.deleteItem(cart);
                    break;
                case 2:
                    ApplicationContext.orderService.orderCart(cart, customer);
                    System.out.println("Your orders ordered successfully.");
                    return null;
                case 3:
                    return null;
            }
        }
    }
}
