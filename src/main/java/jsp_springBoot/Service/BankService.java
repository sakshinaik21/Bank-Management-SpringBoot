package jsp_springBoot.Service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jsp_springBoot.Entity.Bank;
import jsp_springBoot.Exception.BankNotFoundException;
import jsp_springBoot.Repository.BankRepository;

@Service
public class BankService {

    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    // CREATE BANK
    public Bank createBank(Bank bank) {

        if (bankRepository.existsByIfsc(bank.getIfsc())) {
            throw new RuntimeException("IFSC already exists");
        }

        if (bankRepository.existsByContact(bank.getContact())) {
            throw new RuntimeException("Contact number already exists");
        }

        return bankRepository.save(bank);
    }

    // GET ALL BANKS
    public List<Bank> getAllBanks() {

        return bankRepository.findAll();
    }

    // GET BANK BY ID
    public Bank getBankById(Long id) {

        return bankRepository.findById(id)
                .orElseThrow(() ->
                        new BankNotFoundException(
                                "Bank not found with ID: " + id));
    }

    // GET BANK BY IFSC
    public Bank getBankByIfsc(String ifsc) {

        return bankRepository.findByIfsc(ifsc)
                .orElseThrow(() ->
                        new BankNotFoundException(
                                "Bank not found with IFSC: " + ifsc));
    }

    // GET BANK BY CONTACT
    public Bank getBankByContact(String contact) {

        return bankRepository.findByContact(contact)
                .orElseThrow(() ->
                        new BankNotFoundException(
                                "Bank not found with contact: " + contact));
    }

    // GET BANKS BY CITY
    public List<Bank> getBanksByCity(String city) {

        return bankRepository.findByAddress_City(city);
    }

    // GET BANKS BY STATE
    public List<Bank> getBanksByState(String state) {

        return bankRepository.findByAddress_State(state);
    }

    // PAGINATION + SORTING
    public Page<Bank> getBanks(Pageable pageable) {

        return bankRepository.findAll(pageable);
    }

    // DELETE BANK
    public void deleteBank(Long id) {

        if (!bankRepository.existsById(id)) {
            throw new BankNotFoundException(
                    "Bank not found with ID: " + id);
        }

        bankRepository.deleteById(id);
    }

    public List<Bank> createBanks(List<Bank> banks) {

        return bankRepository.saveAll(banks);
    }
}