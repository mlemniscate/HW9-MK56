package ir.maktab.store.front.menu;


import ir.maktab.store.ApplicationContext;
import ir.maktab.store.domain.Cart;

import java.sql.SQLException;

public class ShowCartMenu extends Menu implements RunnableMenu<Void>{
    private final Cart cart;

    public ShowCartMenu(Cart cart) {
        super(new String[]{"Delete Item", "Final Payment", "Back"});
        this.cart = cart;
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
                    ApplicationContext.orderService.orderCart(cart);
                    System.out.println("Your orders ordered successfully.");
                    return null;
                case 3:
                    return null;
            }
        }
    }

    /*private void payment() throws SQLException {
        double paymentPrice = TakenProductService.calculateTakenProductsPrice(cart);
        if (cart.getBalance() > paymentPrice) {
            Shipper shipper = ShipperService.chooseShipper();
            paymentPrice += shipper.getPrice();
            if(cart.getBalance() > paymentPrice) {
                updateBalance(paymentPrice);
                Order order = new Order(cart, new Timestamp(new Date().getTime()), shipper);
                OrderService.addOrder(order);
                addOrderDetails(cart, OrderService.getLastOrder());
                cart.getTakenProducts().clear();
            } else {
                System.out.println("Your balance not enough for this payment.\nPlease deposit your balance and come back again.");
            }
        } else {
            System.out.println("Your balance not enough for this payment.\nPlease deposit your balance and come back again.");
        }
    }

    private void addOrderDetails(Cart customer, Order order) throws SQLException {
        for (int i = 0; i < customer.getTakenProducts().size(); i++) {
            OrderDetailService.addOrderDetail(new OrderDetail(
                    order,
                    customer.getTakenProducts().get(i).getProduct(),
                    customer.getTakenProducts().get(i).getQuantity()
            ));
        }
    }

    private void updateBalance(double paymentPrice) throws SQLException {
        cart.setBalance(cart.getBalance() - paymentPrice);
        CustomerService.update(cart);
    }*/
}
