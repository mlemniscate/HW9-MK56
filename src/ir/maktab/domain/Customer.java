package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;

public class Customer extends BaseEntity<Long> {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private double balance;

    public Customer(String firstName, String lastName, String username, String password) {
        this(firstName, lastName, username, password, 0D);
    }

    public Customer(String firstName, String lastName, String username, String password, Double balance) {
        this(0L, firstName, lastName, username, password, balance);
    }

    public Customer(Long id, String firstName, String lastName, String username, String password, Double balance) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
