package co.pragra.amex.bankapp.api;

import co.pragra.amex.bankapp.entity.Account;
import co.pragra.amex.bankapp.service.AccountService;
import co.pragra.amex.bankapp.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class AccountApi {

    private final AccountService accountService;

    public AccountApi(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{uuid}/account")
    public ResponseEntity<Account> createAccount(@RequestBody Account account, @PathVariable String uuid) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(account,UUID.fromString(uuid)));
    }
}
