package jsp_springBoot.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jsp_springBoot.DTO.AccountRequest;
import jsp_springBoot.Entity.Account;
import jsp_springBoot.Entity.AccountType;
import jsp_springBoot.Entity.Bank;
import jsp_springBoot.Exception.AccountNotFoundException;
import jsp_springBoot.Exception.BankNotFoundException;
import jsp_springBoot.Repository.AccountRepository;
import jsp_springBoot.Repository.BankRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final BankRepository bankRepository;

    public AccountService(AccountRepository accountRepository,
                          BankRepository bankRepository) {

        this.accountRepository = accountRepository;
        this.bankRepository = bankRepository;
    }

    // =====================================================
    // CREATE ONE ACCOUNT
    // =====================================================

    public Account createAccount(Long bankId, Account account) {

        if (accountRepository.existsByAccountNumber(
                account.getAccountNumber())) {

            throw new RuntimeException(
                    "Account number already exists: "
                            + account.getAccountNumber());
        }

        Bank bank = bankRepository.findById(bankId)
                .orElseThrow(() ->
                        new BankNotFoundException(
                                "Bank not found with ID: " + bankId));

        account.setBank(bank);

        return accountRepository.save(account);
    }


    // =====================================================
    // CREATE MULTIPLE ACCOUNTS
    // =====================================================

    public List<Account> createAccounts(
            List<AccountRequest> requests) {

        List<Account> accounts = new ArrayList<>();

        for (AccountRequest request : requests) {

            // Check duplicate account number
            if (accountRepository.existsByAccountNumber(
                    request.getAccountNumber())) {

                throw new RuntimeException(
                        "Account number already exists: "
                                + request.getAccountNumber());
            }

            // Find bank using bankId
            Bank bank = bankRepository.findById(
                    request.getBankId())
                    .orElseThrow(() ->
                            new BankNotFoundException(
                                    "Bank not found with ID: "
                                            + request.getBankId()));

            // Create Account object
            Account account = new Account();

            account.setAccountNumber(
                    request.getAccountNumber());

            account.setHolderName(
                    request.getHolderName());

            account.setAccountType(
                    request.getAccountType());

            account.setBalance(
                    request.getBalance());

            // Connect Account with Bank
            account.setBank(bank);

            accounts.add(account);
        }

        return accountRepository.saveAll(accounts);
    }


    // =====================================================
    // GET ALL ACCOUNTS
    // =====================================================

    public List<Account> getAllAccounts() {

        return accountRepository.findAll();
    }


    // =====================================================
    // GET ACCOUNT BY ID
    // =====================================================

    public Account getAccountById(Long id) {

        return accountRepository.findById(id)
                .orElseThrow(() ->
                        new AccountNotFoundException(
                                "Account not found with ID: " + id));
    }


    // =====================================================
    // GET ACCOUNT BY ACCOUNT NUMBER
    // =====================================================

    public Account getAccountByNumber(
            String accountNumber) {

        return accountRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new AccountNotFoundException(
                                "Account not found with account number: "
                                        + accountNumber));
    }


    // =====================================================
    // GET ACCOUNTS BY ACCOUNT TYPE
    // =====================================================

    public List<Account> getAccountsByType(
            AccountType accountType) {

        return accountRepository
                .findByAccountType(accountType);
    }


    // =====================================================
    // GET ACCOUNTS BY BANK
    // =====================================================

    public List<Account> getAccountsByBank(Long bankId) {

        if (!bankRepository.existsById(bankId)) {

            throw new BankNotFoundException(
                    "Bank not found with ID: " + bankId);
        }

        return accountRepository
                .findByBank_BankId(bankId);
    }


    // =====================================================
    // GET ACCOUNTS WITH MINIMUM BALANCE
    // =====================================================

    public List<Account> getAccountsByMinimumBalance(
            double balance) {

        return accountRepository
                .findByBalanceGreaterThan(balance);
    }


    // =====================================================
    // DEPOSIT MONEY
    // =====================================================

    public Account deposit(
            Long accountId,
            double amount) {

        if (amount <= 0) {

            throw new RuntimeException(
                    "Deposit amount must be greater than zero");
        }

        Account account = getAccountById(accountId);

        account.setBalance(
                account.getBalance() + amount);

        return accountRepository.save(account);
    }


    // =====================================================
    // WITHDRAW MONEY
    // =====================================================

    public Account withdraw(
            Long accountId,
            double amount) {

        if (amount <= 0) {

            throw new RuntimeException(
                    "Withdrawal amount must be greater than zero");
        }

        Account account = getAccountById(accountId);

        if (account.getBalance() < amount) {

            throw new RuntimeException(
                    "Insufficient balance");
        }

        account.setBalance(
                account.getBalance() - amount);

        return accountRepository.save(account);
    }


    // =====================================================
    // DELETE ACCOUNT
    // =====================================================

    public String deleteAccount(Long accountId) {

        if (!accountRepository.existsById(accountId)) {

            throw new AccountNotFoundException(
                    "Account not found with ID: " + accountId);
        }

        accountRepository.deleteById(accountId);

        return "Account deleted successfully";
    }
}