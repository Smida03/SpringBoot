package tn.TAKWIRAProject.services;

import java.util.List;

import tn.TAKWIRAProject.entities.client;

public interface IClientService {
	public List<client> getAllClients();
	public client getClientById(Long id);
	public client addClient(client client);
	public client updateClient(client client);
	public void deleteClient(Long id);
	public client addutilisateurRole(Long id, Long idRole);
}
