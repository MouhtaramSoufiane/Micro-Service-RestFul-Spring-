package ma.enset.bankAccountservice.Repository;

import ma.enset.bankAccountservice.Entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<BankAccount , String>{

}
