package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.domain.Customer;
import ir.maktab.store.repository.CustomerRepository;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerRepository> {

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
