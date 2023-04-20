package tn.TAKWIRAProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.TAKWIRAProject.entities.client; 
import tn.TAKWIRAProject.services.IClientService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    // Get all clients
    @GetMapping("/")
    public ResponseEntity<List<client>> getAllClients() {
        List<client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    // Get client by ID
    @GetMapping("/{id}")
    public ResponseEntity<client> getClientById(@PathVariable Long id) {
        client client = clientService.getClientById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    // Add client
    @PostMapping("/")
    public ResponseEntity<client> addClient(@RequestBody client client) {
        client newClient = clientService.addClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    // Update client
    @PutMapping("/{id}")
    public ResponseEntity<client> updateClient(@PathVariable("id") Long id, @RequestBody client update) {
        client existing = clientService.getClientById(id);
        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (update.getNom() != null) {
            existing.setNom(update.getNom());
        }
        if (update.getPrenom() != null) {
            existing.setPrenom(update.getPrenom());
        }
        if (update.getPrenom() != null) {
            existing.setPrenom(update.getPrenom());
        }
        if (update.getMotDePasse() != null) {
            existing.setMotDePasse(update.getMotDePasse());
        }
        if (update.getConfirmationMotDePasse() != null) {
            existing.setConfirmationMotDePasse(update.getConfirmationMotDePasse());
        }
        if (update.getPhone() != null) {
            existing.setPhone(update.getPhone());
        }
        if (update.getAdresse() != null) {
            existing.setAdresse(update.getAdresse());
        }
        if (update.getPays() != null) {
            existing.setPays(update.getPays());
        }
        client updatedClient = clientService.updateClient(existing);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

    // Delete client by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id) {
    	client existingClient = clientService.getClientById(id);

        if (existingClient == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    }
    
    @PostMapping("/addutilisateurRole/{id}/{idRole}")
    public client addutilisateurRole(@PathVariable("id") Long id, @PathVariable("idRole") Long idRole) {
    	return clientService.addutilisateurRole(id, idRole);
    }
}
