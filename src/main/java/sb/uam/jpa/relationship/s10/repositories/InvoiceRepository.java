package sb.uam.jpa.relationship.s10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.uam.jpa.relationship.s10.entities.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
