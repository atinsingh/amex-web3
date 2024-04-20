package co.pragra.amex.bankapp.repo;

import co.pragra.amex.bankapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepo  extends JpaRepository<Customer, UUID> {
}
