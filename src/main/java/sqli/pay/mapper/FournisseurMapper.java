package sqli.pay.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import sqli.pay.domain.Fournisseur;
import sqli.pay.dto.FournisseurDto;

public class FournisseurMapper {
	private FournisseurMapper() {
	}

	public static FournisseurDto toDto(Fournisseur fournisseur) {
		if (fournisseur == null) {
			return null;
		}
		return FournisseurDto.builder().id(fournisseur.getId()).nom(fournisseur.getNom()).prenom(fournisseur.getPrenom())
				.domaine(fournisseur.getDomaine()).build();
	}

	public static List<FournisseurDto> toDtos(List<Fournisseur> fournisseurs) {
		if (fournisseurs != null) {
			return fournisseurs.stream().filter(Objects::nonNull).map(FournisseurMapper::toDto).collect(Collectors.toList());
		} else

		{
			return null;
		}
	}

	public static Fournisseur toEntity(FournisseurDto fournisseursDto) {
		if (fournisseursDto != null) {
			return Fournisseur.builder().id(fournisseursDto.getId()).nom(fournisseursDto.getNom()).prenom(fournisseursDto.getPrenom())
					.domaine(fournisseursDto.getDomaine()).build();
		} else {
			return null;
		}
	}
}
