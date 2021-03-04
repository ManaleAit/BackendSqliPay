package sqli.pay.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sqli.pay.dto.FournisseurDto;
import sqli.pay.exception.ExceptionCode;
import sqli.pay.exception.MicroServiceException;
import sqli.pay.mapper.FournisseurMapper;
import sqli.pay.repository.FournisseurRepository;

@Service
@Transactional
public class FournisseurService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurService.class);

	@Autowired
	private FournisseurRepository fournisseurRepository;

	public FournisseurDto findById(Long id) throws MicroServiceException {
		try {
			LOGGER.debug("START SERVICE find by id {}", id);
			return Optional.ofNullable(fournisseurRepository.findById(id)).map(v -> FournisseurMapper.toDto(v.get())).orElseThrow(
					() -> new MicroServiceException(ExceptionCode.API_RESOURCE_NOT_FOUND, "suppiler not found"));
		} catch (Throwable t) {
			throw new MicroServiceException(ExceptionCode.API_RESOURCE_NOT_FOUND, "Fournisseur not found");
		}
	}

	public List<FournisseurDto> findAll() throws MicroServiceException {
		LOGGER.debug("START SERVICE find all");
		return Optional.ofNullable(fournisseurRepository.findAll()).map(FournisseurMapper::toDtos)
				.orElseThrow(() -> new MicroServiceException(ExceptionCode.API_RESOURCE_NOT_FOUND, "Fournisseurs not found"));
	}

	public void delete(Long id) throws MicroServiceException {

		if (!fournisseurRepository.findById(id).isPresent()) {

			throw new MicroServiceException(ExceptionCode.API_RESOURCE_NOT_FOUND, "Fournisseur not found");
		}
		LOGGER.debug("START SERVICE delete by id {}", id);
		fournisseurRepository.deleteById(id);
		LOGGER.debug("START SERVICE delete by id {}", id);

	}

	public void save(FournisseurDto FournisseurDto) throws MicroServiceException {
		try {
			LOGGER.debug("START SERVICE save by id {}, name: {}", FournisseurDto.getId(), FournisseurDto.getNom());
			fournisseurRepository.save(FournisseurMapper.toEntity(FournisseurDto));
			LOGGER.debug("START SERVICE save by id {}, name: {}", FournisseurDto.getId(), FournisseurDto.getNom());
		} catch (Throwable t) {
			throw new MicroServiceException(ExceptionCode.API_DATA_ERRORS, "Resource is null");
		}
	}
}
