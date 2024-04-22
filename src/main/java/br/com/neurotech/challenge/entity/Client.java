package br.com.neurotech.challenge.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.EntityModel;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Client {

	@Id
	@SequenceGenerator(name = "sequence_client" , sequenceName = "SEQ_CLIENT", initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_client")
	private Long id;

	private String name;
	private Integer age;
	private Double income;

}