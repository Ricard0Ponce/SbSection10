package sb.uam.jpa.relationship.s10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.uam.jpa.relationship.s10.entities.Address;
import sb.uam.jpa.relationship.s10.entities.Client;
import sb.uam.jpa.relationship.s10.repositories.AddressRepository;
import sb.uam.jpa.relationship.s10.repositories.ClientRepository;

import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientRepository clientRepository;// Se realiza la inyeccion de dependencias necesaria para almacenar la direccion al cliente

    @Override
    @Transactional
    public Optional<Address> createAddress(Long clientId, Address address) {
        Optional<Client> clientOpt = clientRepository.findById(clientId); // Se busca el cliente por el id que recibimos
        if (clientOpt.isPresent()) { // Si el cliente existe se realiza lo siguiente
            Client client = clientOpt.get(); // Creamos un objeto cliente con el cliente que encontramos asignandolo a la variable client
            client.getAddresses().add(address); // Agregamos la direccion que recibimos desde el RequestBody al cliente
            addressRepository.save(address); // almacenamos la direccion
            return Optional.of(address); // Retornamos la direccion
        }
        return Optional.empty(); // Si el if da false retornamos un Optional vacio
    }

    @Override
    @Transactional
    public Optional<Object> removeAddress(Long idAdress, Long idClient) {
        Optional<Client> clientOpt = clientRepository.findById(idClient); // Buscamos el cliente por el id que recibimos
        if(clientOpt.isPresent()){
            Client client = clientOpt.get(); // Creamos un objeto cliente con el cliente que encontramos asignandolo a la variable client
            Optional<Address> addressOpt = client.getAddresses()
                    .stream()
                    .filter(address -> address.getId().equals(idAdress)).findFirst(); // Buscamos la direccion que queremos eliminar
            if(addressOpt.isPresent()){ // Si la direccion existe
                Address address = addressOpt.get(); // Creamos un objeto direccion con la direccion que encontramos asignandolo a la variable address
                client.getAddresses().remove(address); // Eliminamos la direccion del cliente
                addressRepository.delete(address); // Eliminamos la direccion
                return Optional.of(address); // Retornamos la direccion
            }
        }
        return Optional.empty();
    }
}
