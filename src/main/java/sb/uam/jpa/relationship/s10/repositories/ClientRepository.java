package sb.uam.jpa.relationship.s10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.uam.jpa.relationship.s10.entities.Client;

// Se agrega la anotacion @Repository para que Spring sepa que esta clase es un repositorio
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
