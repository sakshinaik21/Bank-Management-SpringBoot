package jsp_springBoot.DTO;

import lombok.Data;
import jsp_springBoot.Entity.AccountType;

@Data
public class AccountRequest {

    private String accountNumber;

    private String holderName;

    private AccountType accountType;

    private double balance;

    private Long bankId;
}