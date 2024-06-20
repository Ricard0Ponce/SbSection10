package sb.uam.jpa.relationship.s10.services;

import sb.uam.jpa.relationship.s10.entities.Invoice;

import java.util.Optional;

public interface InvoiceService {
    Optional<Invoice> createInvoice(Long id, Invoice invoice);
}
