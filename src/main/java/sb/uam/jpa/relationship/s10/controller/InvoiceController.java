package sb.uam.jpa.relationship.s10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.uam.jpa.relationship.s10.entities.Invoice;
import sb.uam.jpa.relationship.s10.services.InvoiceService;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/create/{id}")
    public ResponseEntity<Invoice> createInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        return ResponseEntity.ok(invoiceService.createInvoice(id, invoice).orElseThrow(() -> new RuntimeException("Client not found")));
    }

}
