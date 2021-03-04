package sqli.pay.dto;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sqlipay.dto.views.UserView;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FournisseurDto {
	@JsonView(UserView.Basic.class)
	private Long id;
	@JsonView(UserView.Basic.class)
	private String nom;
	@JsonView(UserView.Basic.class)
	private String prenom;
	@JsonView(UserView.Basic.class)
	private String domaine;

}
