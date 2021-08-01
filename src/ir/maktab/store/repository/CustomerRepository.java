package ir.maktab.store.repository;

import ir.maktab.store.base.repository.BaseRepository;
import ir.maktab.store.domain.Customer;

public interface CustomerRepository extends BaseRepository<Customer, Long> {

    Customer findByUsernamePassword(String username, String password);
}
