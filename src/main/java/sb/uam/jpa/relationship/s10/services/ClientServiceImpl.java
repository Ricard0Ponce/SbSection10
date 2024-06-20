package sb.uam.jpa.relationship.s10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.uam.jpa.relationship.s10.entities.Client;
import sb.uam.jpa.relationship.s10.repositories.ClientRepository;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired // La inyeccion de dependencias es necesaria para que funcione el repositorio
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public Optional<Client> createClient(Client client) {
        return Optional.of(clientRepository.save(client));
    }

}
