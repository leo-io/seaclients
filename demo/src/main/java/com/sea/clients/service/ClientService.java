package com.sea.clients.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sea.clients.dto.ViaCepResponseDTO;
import com.sea.clients.entity.Client;
import com.sea.clients.entity.User;
import com.sea.clients.exception.CepNotFoundException;
import com.sea.clients.repository.ClientRepository;
import com.sea.clients.repository.EmailRepository;
import com.sea.clients.repository.PhoneRepository;
import com.sea.clients.repository.UserRepository;

import lombok.RequiredArgsConstructor;

	@Service
	@RequiredArgsConstructor
	public class ClientService {
		
		private final ClientRepository clientRepository;
	    private final PhoneRepository phoneRepository;
	    private final EmailRepository emailRepository;
	    private final UserRepository userRepository;
	    private final ViaCepService viaCepService;

	    public Client createClient(Client client, String userId) {
	        User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
	        
	        ViaCepResponseDTO viaCepResponse = viaCepService.fetchAddressByCep(client.getCep());

	        if (viaCepResponse == null || viaCepResponse.getLogradouro() == null) {
	            throw new CepNotFoundException("CEP not found: " + client.getCep());
	        }

	        client.setStreet(viaCepResponse.getLogradouro());
	        client.setNeighborhood(viaCepResponse.getBairro());
	        client.setCity(viaCepResponse.getLocalidade());
	        client.setState(viaCepResponse.getUf());

	        // Associate the user with the client
	        client.setUser(user);

	        	        // Set the client reference in all phones and emails
	        if (client.getPhones() != null) {
	            client.getPhones().forEach(phone -> phone.setClient(client));
	        }
	        if (client.getEmails() != null) {
	            client.getEmails().forEach(email -> email.setClient(client));
	        }


	        return clientRepository.save(client);
	    }    
	    public List<Client> getAllClients() {
	        return clientRepository.findAll();
	    }

	    public Client getClientById(String clientId) {
	        return clientRepository.findById(clientId)
	            .orElseThrow(() -> new RuntimeException("Client not found"));
	    }
	    
	    public Client updateClient(String clientId, Client updatedClient) {
	        Client existingClient = clientRepository.findById(clientId)
	            .orElseThrow(() -> new RuntimeException("Client not found"));

	        existingClient.setName(updatedClient.getName());
	        existingClient.setCpf(updatedClient.getCpf());
	        existingClient.setCep(updatedClient.getCep());
	        existingClient.setComplement(updatedClient.getComplement());


	        if (!existingClient.getCep().equals(updatedClient.getCep())) {
	        	ViaCepResponseDTO viaCepResponse = viaCepService.fetchAddressByCep(updatedClient.getCep());
	            existingClient.setStreet(viaCepResponse.getLogradouro());
	            existingClient.setNeighborhood(viaCepResponse.getBairro());
	            existingClient.setCity(viaCepResponse.getLocalidade());
	            existingClient.setState(viaCepResponse.getUf());
	        }

	        existingClient.getPhones().clear();
	        existingClient.getPhones().addAll(updatedClient.getPhones());
	        existingClient.getEmails().clear();
	        existingClient.getEmails().addAll(updatedClient.getEmails());

	        existingClient.getPhones().forEach(phone -> phone.setClient(existingClient));
	        existingClient.getEmails().forEach(email -> email.setClient(existingClient));

	        return clientRepository.save(existingClient);
	    }

	    public void deleteClient(String clientId) {
	        clientRepository.deleteById(clientId);
	    }
	}

