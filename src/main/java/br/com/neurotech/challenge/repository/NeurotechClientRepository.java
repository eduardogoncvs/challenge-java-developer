package br.com.neurotech.challenge.repository;

import br.com.neurotech.challenge.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.EntityModel;

import java.util.List;
import java.util.concurrent.Future;

public interface NeurotechClientRepository extends JpaRepository<Client, Long> {

}
