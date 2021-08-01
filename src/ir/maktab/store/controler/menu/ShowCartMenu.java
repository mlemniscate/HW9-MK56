/*
package ir.maktab.store.controler.menu;

import ir.maktab.domain.Customer;
import ir.maktab.domain.Order;
import ir.maktab.domain.OrderDetail;
import ir.maktab.domain.Shipper;
import ir.maktab.util.service.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class ShowCartMenu extends Menu implements RunnableMenu<Void>{
    private Customer customer;

    public ShowCartMenu(Customer customer) {
        super(new String[]{"Delete Item", "Final Payment", "Back"});
        this.customer = customer;
        TakenProductService.showTakenProducts(customer);
    }

    @Override
    public Void runMenu() throws SQLException {
        while (true) {
            showMenu();
            switch (getChosenItem()) {
                case 1:
                    TakenProductService.deleteItem(customer);
                    break;
                case 2:
                    payment();
                    System.out.println("Your orders ordered successfully.");
                    return null;
                case 3:
                    return null;
            }
        }
    }

    private void payment() throws SQLException {
        double paymentPrice = TakenProductService.calculateTakenProductsPrice(customer);
        if (customer.getBalance() > paymentPrice) {
            Shipper shipper = ShipperService.chooseShipper();
            paymentPrice += shipper.getPrice();
            if(customer.getBalance() > paymentPrice) {
                updateBalance(paymentPrice);
                Order order = new Order(customer, new Timestamp(new Date().getTime()), shipper);
                OrderService.addOrder(order);
                addOrderDetails(customer, OrderService.getLastOrder());
                customer.getTakenProducts().clear();
            } else {
                System.out.println("Your balance not enough for this payment.\nPlease deposit your balance and come back again.");
            }
        } else {
            System.out.println("Your balance not enough for this payment.\nPlease deposit your balance and come back again.");
        }
    }

    private void addOrderDetails(Customer customer, Order order) throws SQLException {
        for (int i = 0; i < customer.getTakenProducts().size(); i++) {
            OrderDetailService.addOrderDetail(new OrderDetail(
                    order,
                    customer.getTakenProducts().get(i).getProduct(),
                    customer.getTakenProducts().get(i).getQuantity()
            ));
        }
    }

    private void updateBalance(double paymentPrice) throws SQLException {
        customer.setBalance(customer.getBalance() - paymentPrice);
        CustomerService.update(customer);
    }
}
*/
