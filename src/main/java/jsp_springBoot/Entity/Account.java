package jsp_springBoot.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    private String holderName;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private double balance;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    @JsonIgnore
    private Bank bank;
}