package com.aplication.project.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(client.getEmail());
        if(clientOptional.isPresent()){
            throw new IllegalStateException("Email is already taken");
        }
        clientRepository.save(client);
    }

    public void deleteClient(Integer clientId) {
        boolean exists = clientRepository.existsById(clientId);
        if(!exists){
            throw new IllegalStateException("Client with id " + clientId + " does not exists");

        }
        clientRepository.deleteById(clientId);
    }

    @Transactional
    public void updateClient(Integer clientId, String name, String surname, String email, String login, String password){
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalStateException("client with id " + clientId + " does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(client.getName(), name)){
            client.setName(name);
        }
        if(surname != null && surname.length() > 0 && !Objects.equals(client.getSurname(), surname)){
            client.setSurname(surname);
        }
        if(email != null && email.length() > 0 && !Objects.equals(client.getEmail(), email)){
            Optional<Client> clientOptional = clientRepository.findClientByEmail(email);
            if(clientOptional.isPresent()){
                throw new IllegalStateException("This email is already taken");
            }
            client.setEmail(email);
        }
        if(login != null && login.length() > 0 && !Objects.equals(client.getLogin(), login)){
            client.setLogin(login);
        }
    }
}
