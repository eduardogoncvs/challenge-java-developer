package br.com.neurotech.challenge.model;

import br.com.neurotech.challenge.entity.Client;
import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.EntityModel;

@Builder
@Getter
public class ClientDTO {

    public Long id;

    public String name;
    public Integer age;
    public Double income;

    public static EntityModel<Client> toModel(Client client) {
        return null;
    }
}
