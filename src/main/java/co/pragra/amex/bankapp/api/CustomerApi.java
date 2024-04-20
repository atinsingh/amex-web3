package co.pragra.amex.bankapp.api;

import co.pragra.amex.bankapp.entity.Customer;
import co.pragra.amex.bankapp.exceptions.CustomerDataException;
import co.pragra.amex.bankapp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class CustomerApi {
    private final CustomerService service;

    public CustomerApi(CustomerService service) {
        this.service = service;
    }


    @PostMapping("")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
            return ResponseEntity.status(HttpStatus.CREATED).body(  service.createCustomer(customer));
    }


    @GetMapping("")
    public ResponseEntity<List<Customer>> getByAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getALl());
    }

    @RequestMapping("/{uuid}")
    public ResponseEntity<Customer> getById(@PathVariable String uuid) {
        UUID fromString = UUID.fromString(uuid);
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(fromString));
    }

}
