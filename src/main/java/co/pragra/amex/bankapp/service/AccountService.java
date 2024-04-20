package co.pragra.amex.bankapp.service;

import co.pragra.amex.bankapp.entity.Account;
import co.pragra.amex.bankapp.entity.Customer;
import co.pragra.amex.bankapp.exceptions.NoDataFoundException;
import co.pragra.amex.bankapp.repo.AccountRepo;
import co.pragra.amex.bankapp.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepo accountRepo;
    private final CustomerRepo customerRepo;

    public AccountService(AccountRepo accountRepo, CustomerRepo customerRepo) {
        this.accountRepo = accountRepo;
        this.customerRepo = customerRepo;
    }

    public Account createAccount(Account account, UUID uuid){
        if(uuid == null) {
            throw  new RuntimeException("UUID can't be null");
        }
        Customer customer = customerRepo.findById(uuid).orElseThrow(() -> new NoDataFoundException("Customer with UUID" + uuid.toString() + " not found"));
        Account saved = accountRepo.save(account);
        List<Account> accounts = customer.getAccounts();
        accounts.add(saved);
        customer.setAccounts(accounts);
        customerRepo.save(customer);
        return saved;
    }
}
