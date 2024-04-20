package co.pragra.amex.bankapp.service;

import co.pragra.amex.bankapp.entity.Customer;
import co.pragra.amex.bankapp.exceptions.CustomerDataException;
import co.pragra.amex.bankapp.exceptions.NoDataFoundException;
import co.pragra.amex.bankapp.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepo repo;

    public CustomerService(CustomerRepo repo) {
        this.repo = repo;
    }

    public Customer createCustomer(Customer customer) {
        if( customer.getFirstName()==null || customer.getFirstName().length()<3) {
            throw new CustomerDataException("First Name can't be null or less than 3 chars");
        }
        customer.setCreateDate(new Date());
        customer.setUpdateDate(new Date());
       return repo.save(customer);
    }

    public List<Customer> getALl(){
        List<Customer> all = repo.findAll();
        if(all.size()==0){
            new NoDataFoundException("No customer available ");
        }
        return all;
    }

    public Customer getById(UUID uuid) {
        if(uuid == null) {
            throw  new RuntimeException("UUID can't be null");
        }
       return repo.findById(uuid).orElseThrow(()->new CustomerDataException("UUID Doesn't exits in system"));
    }
}
