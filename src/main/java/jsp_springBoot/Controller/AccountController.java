package jsp_springBoot.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jsp_springBoot.DTO.AccountRequest;

import jsp_springBoot.Entity.Account;
import jsp_springBoot.Entity.AccountType;
import jsp_springBoot.Service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // CREATE ONE ACCOUNT
    @PostMapping("/bank/{bankId}")
    public Account createAccount(
            @PathVariable Long bankId,
            @RequestBody Account account) {

        return accountService.createAccount(bankId, account);
    }

    // CREATE ACCOUNTS IN BULK
    @PostMapping("/bulk")
    public List<Account> createAccounts(
            @RequestBody List<AccountRequest> requests) {

        return accountService.createAccounts(requests);
    }
    // GET ALL
    @GetMapping
    public List<Account> getAllAccounts() {

        return accountService.getAllAccounts();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Account getAccountById(
            @PathVariable Long id) {

        return accountService.getAccountById(id);
    }

    // GET BY ACCOUNT NUMBER
    @GetMapping("/number/{accountNumber}")
    public Account getAccountByNumber(
            @PathVariable String accountNumber) {

        return accountService.getAccountByNumber(accountNumber);
    }

    // GET BY ACCOUNT TYPE
    @GetMapping("/type/{accountType}")
    public List<Account> getAccountsByType(
            @PathVariable AccountType accountType) {

        return accountService.getAccountsByType(accountType);
    }

    // GET BY BANK
    @GetMapping("/bank/{bankId}")
    public List<Account> getAccountsByBank(
            @PathVariable Long bankId) {

        return accountService.getAccountsByBank(bankId);
    }

    // GET BY MINIMUM BALANCE
    @GetMapping("/balance")
    public List<Account> getAccountsByMinimumBalance(
            @RequestParam double amount) {

        return accountService.getAccountsByMinimumBalance(amount);
    }

    // DEPOSIT
    @PutMapping("/{id}/deposit")
    public Account deposit(
            @PathVariable Long id,
            @RequestParam double amount) {

        return accountService.deposit(id, amount);
    }

    // WITHDRAW
    @PutMapping("/{id}/withdraw")
    public Account withdraw(
            @PathVariable Long id,
            @RequestParam double amount) {

        return accountService.withdraw(id, amount);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteAccount(
            @PathVariable Long id) {

        return accountService.deleteAccount(id);
    }
    
    
}