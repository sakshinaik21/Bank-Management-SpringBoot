package jsp_springBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp_springBoot.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
