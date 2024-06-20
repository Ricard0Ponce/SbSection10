package sb.uam.jpa.relationship.s10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sb.uam.jpa.relationship.s10.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService; // Recuerda siempre inyectar la interfaz y no la clase.
}
