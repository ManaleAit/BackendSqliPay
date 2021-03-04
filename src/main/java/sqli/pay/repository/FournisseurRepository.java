package sqli.pay.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import sqli.pay.domain.Admin;
import sqli.pay.domain.Fournisseur;

public interface FournisseurRepository  extends MongoRepository<Fournisseur, Long> {

}

