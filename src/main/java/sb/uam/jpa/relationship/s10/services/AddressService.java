package sb.uam.jpa.relationship.s10.services;


import sb.uam.jpa.relationship.s10.entities.Address;

import java.util.Optional;

public interface AddressService {
    Optional<Address> createAddress(Long id, Address address);
    Optional<Object> removeAddress(Long idAdress, Long idClient);
}
