package jsp_springBoot.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp_springBoot.Entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Optional<Bank> findByIfsc(String ifsc);

    Optional<Bank> findByContact(String contact);

    boolean existsByIfsc(String ifsc);

    boolean existsByContact(String contact);

    List<Bank> findByAddress_City(String city);

    List<Bank> findByAddress_State(String state);
}