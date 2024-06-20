package sb.uam.jpa.relationship.s10.services;


import sb.uam.jpa.relationship.s10.entities.Client;

import java.util.Optional;

public interface ClientService {
    Optional<Client> createClient(Client client);
}
