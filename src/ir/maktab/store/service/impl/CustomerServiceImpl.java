package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.Customer;
import ir.maktab.store.front.input.InputDouble;
import ir.maktab.store.front.input.InputString;
import ir.maktab.store.repository.CustomerRepository;
import ir.maktab.store.service.CustomerService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerRepository> implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    // Login method for taking username and password from customer and checking for true information
    @Override
    public Customer login() throws SQLException {
        String username = new InputString("Enter your username: ").getStringInput();
        String password = new InputString("Enter your password: ").getStringInput();
        Customer customer = repository.findByUsernamePassword(username, password);
        if (Objects.isNull(customer)) {
            System.out.println("Your username or password is wrong!");
            return null;
        } else return customer;
    }


    // This method create a customer an add it to new Customer list in database
    @Override
    public Customer signUp() throws SQLException {
        Customer customer = enterCustomerInformation();
        if (Objects.isNull(save(customer))) {
            System.out.println("Signed up is not successful");
        } else {
            System.out.println("You signed up successfully.\nNow you can login with your information.");
        }
        return customer;
    }

    @Override
    public void depositBalance(Customer customer) throws SQLException {
        System.out.printf("Your balance is %.2f$%n", customer.getBalance());
        double depositAmount = enterDepositAmount();
        customer.setBalance(customer.getBalance() + depositAmount);
        update(customer);
        System.out.printf("Now your balance is %.2f$%n", customer.getBalance());
    }

    // This method take all the information for sign a customer and return an Customer with that information
    private Customer enterCustomerInformation() throws SQLException {
        return new Customer(
                enterFirstName(),
                enterLastName(),
                enterUsername(),
                enterPassword(),
                0D
        );
    }

    // Get a String array that made of all the customers usernames
    private String[] getCustomerNames() throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        List<Customer> customers = findAll();
        for (Customer customer : customers) {
            list.add(customer.getUsername());
        }
        return list.toArray(new String[0]);
    }

    // Get customer username
    private String enterUsername() throws SQLException {
        return new InputString("Enter your username: ",
                "Your username not valid(use 8 to 20 alphanumeric characters).\nNotice: Maybe this username taken by other authors.",
                "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$",
                getCustomerNames()).getStringInput();
    }

    // Get customer last name
    private String enterLastName() {
        return new InputString("Enter your last name: ",
                "Your last name must be 2 to 20 alphabetic characters.",
                "^[a-zA-Z]{2,20}$", null).getStringInput();
    }

    // Get customer first name
    private String enterFirstName() {
        return new InputString("Enter your first name: ",
                "Your first name must be 2 to 20 alphabetic characters.",
                "^[a-zA-Z]{2,20}$", null).getStringInput();
    }

    // Get customer password
    private String enterPassword() throws SQLException {
        return new InputString("Enter your password: ",
                "Your password must be minimum 8 characters, at least one letter and one number.",
                "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", null).getStringInput();
    }

    // Get deposit amount from customer
    private double enterDepositAmount() throws SQLException {
        return new InputDouble("Enter your deposit amount between 1$ and 10,000$: ", 10_000, 1, null
        ).getDoubleInput();
    }

    public void editFirstName(Customer customer) throws SQLException {
        customer.setFirstName(enterFirstName());
    }

    public void editLastName(Customer customer) throws SQLException {
        customer.setLastName(enterLastName());
    }

    public void editUsername(Customer customer) throws SQLException {
        customer.setUsername(enterUsername());
    }

    public void editPassword(Customer customer) throws SQLException {
        customer.setPassword(enterPassword());
    }

}
