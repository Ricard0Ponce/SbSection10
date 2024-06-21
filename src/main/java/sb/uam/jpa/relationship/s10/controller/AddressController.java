package sb.uam.jpa.relationship.s10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.uam.jpa.relationship.s10.entities.Address;
import sb.uam.jpa.relationship.s10.services.AddressService;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService; // Recuerda siempre inyectar la interfaz y no la clase.

    @PostMapping("/create/{clientId}")
    public ResponseEntity<Address> createAddress(@PathVariable Long clientId, @RequestBody Address address){
        Optional<Address> createdAddress = addressService.createAddress(clientId, address); // createdAddres nos va a permitir saber si se creo la direccion o no.
        return createdAddress
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                        .build()); // Devolvemos un ResponseEntity con el status correspondiente.
    }

    @DeleteMapping("/remove/{idAddress}/{idClient}")
    public ResponseEntity<Object> removeAddress(@PathVariable Long idAddress, @PathVariable Long idClient){
        Optional<Object> removedAddress = addressService.removeAddress(idAddress, idClient); // removedAddress nos va a permitir saber si se elimino la direccion o no.
        return removedAddress
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                        .build()); // Devolvemos un ResponseEntity con el status correspondiente.
    }
}
