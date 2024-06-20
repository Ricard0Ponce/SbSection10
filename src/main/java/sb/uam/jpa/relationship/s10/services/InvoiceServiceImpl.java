package sb.uam.jpa.relationship.s10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.uam.jpa.relationship.s10.entities.Invoice;
import sb.uam.jpa.relationship.s10.repositories.ClientRepository;
import sb.uam.jpa.relationship.s10.repositories.InvoiceRepository;

import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public Optional<Invoice> createInvoice(Long clientId, Invoice invoice) {
        return clientRepository.findById(clientId).map(client -> { // Se busca el cliente por id, luego se mapea el cliente encontrado
            invoice.setClient(client); // Si el cliente existe, se asigna al invoice
            return invoiceRepository.save(invoice); // Se guarda el invoice
        }); // Si no lo encuentra devuelve un Optional vacío o  Optional.empty()
    }

}
