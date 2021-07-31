package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.domain.Customer;
import ir.maktab.repository.CustomerRepository;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerRepository> {

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
