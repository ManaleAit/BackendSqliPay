package sqli.pay.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sqli.pay.dto.FournisseurDto;
import sqli.pay.exception.MicroServiceException;
import sqli.pay.service.FournisseurService;
import sqlipay.dto.views.UserView;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Fournisseur")
public class FournisseurController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurController.class);

	private final FournisseurService fournisseurService;

	public FournisseurController(FournisseurService FournisseurService) {
		this.fournisseurService = FournisseurService;
	}

	@PostMapping
	@JsonView(UserView.Basic.class)
	public void add(@RequestBody FournisseurDto FournisseurDto) throws MicroServiceException {
		LOGGER.debug("START RESOURCE add Fournisseur by name : {}", FournisseurDto.getNom());
		fournisseurService.save(FournisseurDto);
		LOGGER.debug("END RESOURCE add Fournisseur by id : {}, name: {} is ok", FournisseurDto.getId(), FournisseurDto.getNom());
	}

	@PutMapping
	@JsonView(UserView.Basic.class)
	public void update(@RequestBody FournisseurDto FournisseurDto) throws MicroServiceException {
		LOGGER.debug("START RESOURCE update Fournisseur by name : {}, id: {}", FournisseurDto.getNom(), FournisseurDto.getId());
		fournisseurService.save(FournisseurDto);
		LOGGER.debug("END RESOURCE update Fournisseur by id : {}, name: {} is ok", FournisseurDto.getId(), FournisseurDto.getNom());
	}

	@GetMapping("/{id}")
	@JsonView(UserView.Basic.class)
	public FournisseurDto get(@PathVariable Long id) throws MicroServiceException {
		LOGGER.debug("START RESOURCE find Fournisseur by id : {}", id);
		FournisseurDto FournisseurDto = fournisseurService.findById(id);
		LOGGER.debug("END RESOURCE find Fournisseur by id : {}, name :{}", id, FournisseurDto.getNom());
		return FournisseurDto;
	}

	@GetMapping
	@JsonView(UserView.Basic.class)
	public List<FournisseurDto> getAll() throws MicroServiceException {
		LOGGER.debug("START RESOURCE all find cities");
		List<FournisseurDto> FournisseurDtos = fournisseurService.findAll();
		LOGGER.debug("END RESOURCE find all cities, size: {}", FournisseurDtos.size());
		return FournisseurDtos;
	}

	@DeleteMapping("/{id}")
	@JsonView(UserView.Basic.class)
	public void delete(@PathVariable Long id) throws MicroServiceException {
		LOGGER.debug("START RESOURCE delete Fournisseur by id : {}", id);
		fournisseurService.delete(id);
		LOGGER.debug("END RESOURCE delete Fournisseur by id : {}, is ok", id);
	}
}
