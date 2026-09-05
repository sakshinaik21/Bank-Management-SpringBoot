package jsp_springBoot.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp_springBoot.Entity.Account;
import jsp_springBoot.Entity.AccountType;

public interface AccountRepository
        extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);

    List<Account> findByBank_BankId(Long bankId);

    List<Account> findByAccountType(AccountType accountType);

    List<Account> findByBalanceGreaterThan(double balance);

    boolean existsByBank_BankId(Long bankId);

	boolean existsByAccountNumber(String accountNumber);
}