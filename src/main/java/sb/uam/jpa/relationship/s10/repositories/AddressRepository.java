package sb.uam.jpa.relationship.s10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.uam.jpa.relationship.s10.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
