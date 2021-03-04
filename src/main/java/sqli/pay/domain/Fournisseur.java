package sqli.pay.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Fournisseur")
public class Fournisseur {
	private Long id;
	private String nom;
	private String prenom;
	private String domaine;

}
