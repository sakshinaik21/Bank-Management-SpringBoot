package jsp_springBoot.Controller;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jsp_springBoot.Entity.Account;
import jsp_springBoot.Entity.Bank;
import jsp_springBoot.Service.BankService;

@RestController
@RequestMapping("/banks")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    // CREATE BANK
    @PostMapping
    public Bank createBank(@RequestBody Bank bank) {

        return bankService.createBank(bank);
    }

    // GET ALL BANKS
    @GetMapping
    public List<Bank> getAllBanks() {

        return bankService.getAllBanks();
    }

    // GET BANK BY ID
    @GetMapping("/{id}")
    public Bank getBankById(@PathVariable Long id) {

        return bankService.getBankById(id);
    }

    // GET BANK BY IFSC
    @GetMapping("/ifsc/{ifsc}")
    public Bank getBankByIfsc(@PathVariable String ifsc) {

        return bankService.getBankByIfsc(ifsc);
    }

    // GET BANK BY CONTACT
    @GetMapping("/contact/{contact}")
    public Bank getBankByContact(@PathVariable String contact) {

        return bankService.getBankByContact(contact);
    }

    // GET BANKS BY CITY
    @GetMapping("/city/{city}")
    public List<Bank> getBanksByCity(@PathVariable String city) {

        return bankService.getBanksByCity(city);
    }

    // GET BANKS BY STATE
    @GetMapping("/state/{state}")
    public List<Bank> getBanksByState(@PathVariable String state) {

        return bankService.getBanksByState(state);
    }

    // PAGINATION + SORTING
    @GetMapping("/page")
    public Page<Bank> getBanks(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "bankName") String sortBy) {

        PageRequest pageable =
                PageRequest.of(
                        page,
                        size,
                        Sort.by(sortBy).ascending());

        return bankService.getBanks(pageable);
    }

    // DELETE BANK
    @DeleteMapping("/{id}")
    public String deleteBank(@PathVariable Long id) {

        bankService.deleteBank(id);

        return "Bank deleted successfully";
    }
    
    @PostMapping("/bulk")
    public List<Bank> createBanks(@RequestBody List<Bank> banks) {

        return bankService.createBanks(banks);
    }
    
   
}