package ma.enset.ebankaccountservice.repositories;

import ma.enset.ebankaccountservice._tools.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<Account,String> {
}
