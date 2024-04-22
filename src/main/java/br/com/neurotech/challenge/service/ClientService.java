package br.com.neurotech.challenge.service;

import br.com.neurotech.challenge.entity.Client;
import br.com.neurotech.challenge.exceptions.ClientNotFoundException;
import br.com.neurotech.challenge.model.ClientDTO;
import br.com.neurotech.challenge.repository.NeurotechClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;

import java.net.URI;
import java.util.Optional;

@Service
public class ClientService {

	@Autowired
	private NeurotechClientRepository neurotechClientRepository;

	/**
	 * Salva um novo cliente
	 *
	 * @return ID do cliente recém-salvo
	 */

	public ResponseEntity<?> addNewUser(ClientDTO newClientDTO) {
		Client saveId = neurotechClientRepository.save(Client.builder()
				.name(newClientDTO.name)
				.age(newClientDTO.age)
				.income(newClientDTO.income).build());

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(URI.create("http://localhost/api/client/" + saveId.getId()));
//		responseHeaders.set("Location", "http://localhost/api/client/" + saveId.getId());

		return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);
	}

	/**
	 * Recupera um cliente baseado no seu ID
	 */
	public EntityModel<Client> getClientById(Long clientId) throws ClientNotFoundException {
		Optional<Client> client = neurotechClientRepository.findById(clientId);

		if (client.isPresent()) {
			return ClientDTO.toModel(client.get());
		} else {
			throw new ClientNotFoundException(clientId);
		}
	}
}
