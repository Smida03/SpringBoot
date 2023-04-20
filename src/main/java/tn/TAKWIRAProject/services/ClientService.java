package tn.TAKWIRAProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.TAKWIRAProject.entities.client;
import tn.TAKWIRAProject.entities.role;
import tn.TAKWIRAProject.repository.ClientRepository;
import tn.TAKWIRAProject.repository.RoleRepository;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoleRepository roleRep;
    
    public List<client> getAllClients() {
        return clientRepository.findAll();
    }

    
    public client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    
    public client addClient(client Client) {
        return clientRepository.save(Client);
    }

   
    public client updateClient(client Client) {
        return clientRepository.save(Client);
    }

    
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
    
    public client addutilisateurRole(Long id, Long idRole) {
 	   client client= clientRepository.findById(id).get();
 	   role role= roleRep.findById(idRole).get();
 	   client.addrole(role);
 	   return clientRepository.save(client);
    }
}
