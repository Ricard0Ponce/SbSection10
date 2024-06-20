package sb.uam.jpa.relationship.s10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.uam.jpa.relationship.s10.entities.Address;
import sb.uam.jpa.relationship.s10.repositories.AddressRepository;

import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional
    // Esto nos permitiria crear una direccion asociada a un usuario
    public Optional<Address> createAddress(Address address) {
        return Optional.of(addressRepository.save(address));
    }
}
