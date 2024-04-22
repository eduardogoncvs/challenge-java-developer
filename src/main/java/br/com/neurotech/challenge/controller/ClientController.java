package br.com.neurotech.challenge.controller;

import br.com.neurotech.challenge.entity.Client;
import br.com.neurotech.challenge.exceptions.ClientNotFoundException;
import br.com.neurotech.challenge.model.ClientDTO;
import br.com.neurotech.challenge.repository.NeurotechClientRepository;
import br.com.neurotech.challenge.service.ClientService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private NeurotechClientRepository neurotechClientRepository;
    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public ResponseEntity<List<Client>> clientById() {
        List<Client> clients = neurotechClientRepository.findAll();
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }

    @PostMapping("/client")
    ResponseEntity<?> addNewUser(@RequestBody ClientDTO newClientDTO) {
        return clientService.addNewUser(newClientDTO);
    }

    @GetMapping("/client/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public EntityModel<Client> oneClientById(@PathVariable Long clientId) throws ClientNotFoundException {
        return clientService.getClientById(clientId);
    }
}
