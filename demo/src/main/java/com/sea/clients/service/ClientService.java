package com.sea.clients.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sea.clients.entity.Client;
import com.sea.clients.repository.ClientRepository;
import com.sea.clients.repository.EmailRepository;
import com.sea.clients.repository.PhoneRepository;

import lombok.RequiredArgsConstructor;

	@Service
	@RequiredArgsConstructor
	public class ClientService {
		
		private final ClientRepository clientRepository;
	    private final PhoneRepository phoneRepository;
	    private final EmailRepository emailRepository;

//	    public Client createClient(Client client) {
//	        // Save client first to generate ID
//	        Client savedClient = clientRepository.save(client);
//
//	        // Save phones and emails with client reference
//	        savedClient.getPhones().forEach(phone -> phone.setClient(savedClient));
//	        savedClient.getEmails().forEach(email -> email.setClient(savedClient));
//	        
//	        phoneRepository.saveAll(savedClient.getPhones());
//	        emailRepository.saveAll(savedClient.getEmails());
//
//	        return savedClient;
//	    }

	    public List<Client> getAllClients() {
	        return clientRepository.findAll();
	    }

	    public Client getClientById(String clientId) {
	        return clientRepository.findById(clientId)
	            .orElseThrow(() -> new RuntimeException("Client not found"));
	    }

	    public void deleteClient(String clientId) {
	        clientRepository.deleteById(clientId);
	    }
	}

