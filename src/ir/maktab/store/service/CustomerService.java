package ir.maktab.store.service;

import ir.maktab.store.base.service.BaseService;
import ir.maktab.store.domain.Customer;

import java.sql.SQLException;

public interface CustomerService extends BaseService<Customer, Long> {

    Customer login() throws SQLException;

    Customer signUp() throws SQLException;

    void depositBalance(Customer customer) throws SQLException;
}
